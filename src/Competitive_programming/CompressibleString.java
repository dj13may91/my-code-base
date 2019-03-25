package Competitive_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * compress string like : aabaabaab -> aab3
 * abcdabcd -> abcd2
 * aabaab -> aab2
 * aaaaa -> a5
 * aab -> not appliable
 */

public class CompressibleString {

    public static void main(String[] args) {
        String str = "AbcaAbca";
        char arr[] = str.toCharArray();
        List<Integer> firstCharPositionArray = new ArrayList<>();

        firstCharPositionArray.add(0);
        for (int i = 1; i < arr.length; i++)
            if (arr[0] == arr[i])
                firstCharPositionArray.add(i);

        int attempts = 1;
        while (arr.length / attempts > 1) {
            /**
             * One by one increase the gap between next occurrence of 1st character
             * Example in aabaab -> [0,1,3,4] , next step -> [0,3], next step -> [0,4]
             */
            List<Integer> newPosition = new ArrayList<>();
            int x = 0;
            while (x < firstCharPositionArray.size()) {
                newPosition.add(firstCharPositionArray.get(x));
                x = x + attempts;
            }

            if (newPosition.size() == 1) {
                System.out.println("Not possible to compress string " + str);
                break;
            }
            if (compress(newPosition.size(), newPosition, arr)) {
                System.out.println(str.substring(0, arr.length / newPosition.size()) + newPosition.size());
                break;
            }
            attempts++;
        }
    }

    /**
     * @param dissection             ->  dissect string into these many parts
     * @param firstCharPositionArray
     * @param arr
     * @return
     */
    private static boolean compress(int dissection, List<Integer> firstCharPositionArray, char[] arr) {
        int countMatch = 0; //keeps track of how many characters matched in all substrings
        int partitionSize;
        if (arr.length % dissection == 0)
            partitionSize = arr.length / dissection;
        else
            partitionSize = arr.length / dissection + 1;

        for (int j = 0; j < partitionSize; j++) {
            char currentCh = arr[j];
            for (int i = 0; i < dissection; i++) {
                if (firstCharPositionArray.get(i) + countMatch < arr.length) {
                    char ch = arr[firstCharPositionArray.get(i) + countMatch];
                    if (ch != currentCh) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            countMatch++;
        }
        return true;
    }
}
