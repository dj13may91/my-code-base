/**
 * There are N numbers in array.K iterations have to be performed on the array elements.
 * In each iteration largest element Ai of the array is chosen and added to the answer and removed from array.
 * At the same time floor(Ai/2) is inserted back to the array.
 * Find the value of answer. Initially answer is 0.
 * Print answer modulo 1000000009
 * Input Format
 * First line contain 2 integers N followed by K.
 * Next line contain N space separated integers.
 * Constraints : 1 <= N, K <= 10000 , 1 <= Ai <= 1000000
 * Output Format
 * Print the value of answer.
 * sample Input
 * 2 4
 * 8 9
 * Output: 25
 */

package Competitive_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindSum {

    private static List<Integer> items = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstLine[] = scan.nextLine().split(" ");
        int arraySize = Integer.parseInt(firstLine[0]);
        int iterations = Integer.parseInt(firstLine[1]);
        long sum = 0;
        String arr[] = scan.nextLine().split(" ");
        for (int i = 0; i < arraySize; i++) {
            items.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(items);

        while (iterations > 0) {
            iterations--;
            int head = items.get(items.size() - 1);
            sum = sum + head;
            items.remove(items.size() - 1);
            findInsertIndex((head / 2));
        }
        System.out.print(sum % 1000000009);
    }

    public static void findInsertIndex(int item) {
        int start = 0;
        int end = items.size() - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (item == items.get(mid) || mid <= 0 || mid + 1 == items.size() || ((item > items.get(mid - 1)) && (item < items.get(mid + 1)))) {
//                System.out.println("found");
                break;
            } else if (item > items.get(mid)) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else if (item < items.get(mid)) {
                end = mid - 1;
                mid = (start + end) / 2;
            }
        }
//        System.out.println(start + " " + end + " " + mid);
        insert(item, mid);
    }

    public static void insert(int item, int index) {
        if (index == 0) {
            List<Integer> newItemList = new ArrayList<>();
            newItemList.add(item);
            newItemList.addAll(items);
            items = newItemList;
        } else if (index == items.size() - 1) {
            items.add(item);
        } else {
            List<Integer> newItemList = new ArrayList<>(items.subList(0, index + 1));
            newItemList.add(item);
            newItemList.addAll(items.subList(index + 1, items.size()));
            items = newItemList;
        }
//        System.out.println(items);
    }
}
