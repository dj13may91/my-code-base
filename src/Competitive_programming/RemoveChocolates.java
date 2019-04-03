package Competitive_programming;

//given a box. remove chocolates in combination of 1s and 3s only. give all possible combination total

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveChocolates {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int chocolateCount = Integer.parseInt(scan.nextLine());
        int countOfThrees = 0;
        long possibleCombinations = 1; // as 1st combination is [ 1 1 1 . . . 1 ]
        List<Double> multipliers = new ArrayList<>();
        while (chocolateCount >= 3) {
            if (chocolateCount - 3 >= 0) {
                chocolateCount = chocolateCount - 3;
                countOfThrees++;
                List<Integer> combos = getPossibleCombinations(chocolateCount, countOfThrees);
                double currentCombinations = combos.stream().reduce(1,(a,b) -> a * b);
                multipliers.add(currentCombinations);
            }
        }
        for(double mul : multipliers) {
            possibleCombinations += mul;
            possibleCombinations = possibleCombinations % 1000000007;
        }
        System.out.println(possibleCombinations % 1000000007);
    }

    //Using permutation formula:  [ n!/(r! * (n-r)!) ]
    private static List<Integer> getPossibleCombinations(int chocolateCount, int countOfThrees) {
        List<Integer> chocolates = new ArrayList<>();
        List<Integer> dividers = new ArrayList<>();
        if (chocolateCount > countOfThrees) {
            for (int i = (chocolateCount + 1); i <= (chocolateCount + countOfThrees); i++) {
                chocolates.add(i);
            }
            for (int i = 2; i <= countOfThrees; i++) {
                dividers.add(i);
            }
        } else {
            for (int i = (countOfThrees + 1); i <= (chocolateCount + countOfThrees); i++) {
                chocolates.add(i);
            }
            for (int i = 2; i <= chocolateCount; i++) {
                dividers.add(i);
            }
        }

        for (int i = 0; i < dividers.size(); i++) {
            for (int j = 0; j < chocolates.size(); j++) {
                if (chocolates.get(j) % dividers.get(i) == 0) {
                    chocolates.set(j, chocolates.get(j)/dividers.get(i));
                    j = chocolates.size();
                }
            }
        }
        return chocolates;
    }
}
