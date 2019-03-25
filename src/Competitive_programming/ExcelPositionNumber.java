package Competitive_programming;

import java.util.HashMap;
import java.util.Map;

/**
 * PROBLEM STATEMENT:
 * Given an excel sheet with a column no. such as A or AA , give the number at which it lies.
 * Example: A -> 1 , AA -> 27, AC -> 29
 * Also, given a number, convert it to a position
 * Example: 1 -> A, 16 -> P, 28 -> AB
 */

public class ExcelPositionNumber {

    private static Map<Character, Integer> charPosNumMap = new HashMap<>();
    private static Map<Integer, Character> numCharMap = new HashMap<>();

    public static void main(String[] args) {
        String position = "ABCDE".toUpperCase();
        int positionNum;
        int i = 1;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            charPosNumMap.put(ch, i);
            numCharMap.put(i++, ch);
        }

        positionNum = getPosition(position);
        System.out.println(position + " -> " + positionNum);
        System.out.println(positionNum + " -> " + getPositionIndex(positionNum));
    }

    private static int getPosition(String pos) {
        char arr[] = pos.toUpperCase().toCharArray();
        int posNum = 0;
        for (int i = arr.length; i >= 1; i--) {
            posNum = posNum + (int) (Math.pow(26, arr.length - i) * charPosNumMap.get(arr[i - 1]));
        }
        return posNum;
    }

    private static String getPositionIndex(int positionNum) {
        StringBuilder position = new StringBuilder();
        while (positionNum > 0) {
            position.append(numCharMap.get(positionNum % 26));
            positionNum = positionNum / 26;
        }
        return position.reverse().toString();
    }
}
