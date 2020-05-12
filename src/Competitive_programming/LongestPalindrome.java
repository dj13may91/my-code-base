package Competitive_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

  public static void main(String[] args) {
    char arr[] = "caaabaaacdcaab".toCharArray();
    System.out.println(arr);

    Map<Character, ArrayList<Integer>> charMap = new HashMap<>();

    // store positions of all characters with respective character
    for (int i = 0; i < arr.length; i++) {
      ArrayList<Integer> charPosition = charMap.get(arr[i]);
      if (charPosition == null) {
        charPosition = new ArrayList<>();
      }
      charPosition.add(i);
      charMap.put(arr[i], charPosition);
    }
    System.out.println(charMap);

    int startPosition = 0;
    int maxStart = 1;
    int maxEnd = 0;
    int stepCount = 0;
    while (startPosition < arr.length) {
      char curCh = arr[startPosition];

      ArrayList<Integer> list = new ArrayList<>(charMap.get(curCh));
      while (list.size() > 0) {
        System.out.println(++stepCount + ". getting last palindromic position of current char: '"
            + curCh + "' from list: " + list);
        int index = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        if (maxEnd - maxStart > index - startPosition) {
          System.out.println("Inner break, no longer palindrome possible");
          break;
        }
        if (isPalindrome(arr, startPosition, index)) {
          // check if larger than previous palindrome
          if (index - startPosition > maxEnd - maxStart) {
            maxStart = startPosition;
            maxEnd = index;
            System.out.println("found larger palindrome from " + maxStart + " to " + maxEnd);
            list = new ArrayList<>();
          }
        }
      }
      if (maxEnd - maxStart >= (arr.length - 1) - startPosition) {
        System.out.println("breaking as no longer palindrome possible");
        break;
      }
      startPosition++;
    }

    System.out.print("Largest palindrome: ");
    for (int i = maxStart; i <= maxEnd; i++) {
      System.out.print(arr[i]);
    }
  }

  private static boolean isPalindrome(char arr[], int start, int end) {
    int n = end - start;
    for (int i = 0; i <= (n / 2); i++) {
      if (arr[start + i] != arr[end - i]) {
        return false;
      }
    }
    return true;
  }
}

/**
 * Output: {a=[0, 1, 2, 4, 5, 6, 7], b=[3]} 1. getting last palindromic position of current char:
 * 'a' from list: [0, 1, 2, 4, 5, 6, 7] 2. getting last palindromic position of current char: 'a'
 * from list: [0, 1, 2, 4, 5, 6] found larger palindrome from 0 to 6 3. getting last palindromic
 * position of current char: 'a' from list: [0, 1, 2, 4, 5, 6, 7] 4. getting last palindromic
 * position of current char: 'a' from list: [0, 1, 2, 4, 5, 6] breaking as no longer palindrome
 * possible breaking as no longer palindrome possible Largest palindrome: aaabaaa
 */
