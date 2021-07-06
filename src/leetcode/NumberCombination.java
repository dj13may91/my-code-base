package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NumberCombination {

  public static void main(String[] args) {
    String nums = "23";
    System.out.println(letterCombinations(nums));
  }

  public static List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }
    String[] pad = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    Queue<String> queue1 = new ArrayDeque<>();
    Queue<String> queue2 = new ArrayDeque<>();

    boolean isQ1Active = true;
    for (int i = 0; i < digits.length(); i++) {
      int currNum = Integer.parseInt("" + digits.charAt(i));
      if (i == 0) {
        for (char ch : pad[currNum].toCharArray()) {
          queue2.add("" + ch);
        }
      } else {
        if (isQ1Active) {
          popAndPush(queue2, queue1, pad[currNum]);
        } else {
          popAndPush(queue1, queue2, pad[currNum]);
        }
      }
      isQ1Active = !isQ1Active;
    }
    return isQ1Active ? new ArrayList<>(queue1) : new ArrayList<>(queue2);
  }

  private static void popAndPush(Queue<String> queue1, Queue<String> queue2, String padCombo) {
    while (!queue2.isEmpty()) {
      String s = queue2.poll();
      for (char ch : padCombo.toCharArray()) {
        queue1.add(s + ch);
      }
    }
  }
}
/*
* Given a string containing digits from 2-9 inclusive,
* return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below.
* Note that 1 does not map to any letters.
* */
