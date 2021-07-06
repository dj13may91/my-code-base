package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListSum {

  public static void main(String[] args) {
    System.out.println(romanToInt(intToRoman(58)));
  }

  public static String intToRoman(int num) {
    StringBuilder romanValue = new StringBuilder();
    int[] values = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] romans = new String[]{"I", "IV", "V", "IX", "X",
        "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    for (int i = values.length - 1; i >= 0; i--) {
      int pop = num / values[i];
      while (pop-- > 0) {
        romanValue.append(romans[i]);
      }
      num = num % values[i];
    }
    return romanValue.toString();
  }

  public static int romanToInt(String s) {
    int finalNum = 0;
    Map<String, Integer> numToRomanMap = new HashMap<String, Integer>() {{
      put("I", 1);
      put("IV", 4);
      put("V", 5);
      put("IX", 9);
      put("X", 10);
      put("XL", 40);
      put("L", 50);
      put("XC", 90);
      put("C", 100);
      put("CD", 400);
      put("D", 500);
      put("CM", 900);
      put("M", 1000);
    }};

    for (int i = 0; i < s.length(); i++) {
      StringBuilder currString = new StringBuilder();
      currString.append(s.charAt(i));
      if ((i < s.length() - 1) &&
          (numToRomanMap.get("" + s.charAt(i)) < numToRomanMap.get("" + s.charAt(i + 1)))) {
        currString.append(s.charAt(++i));
      }
      finalNum = finalNum + numToRomanMap.get("" + currString);
    }

    return finalNum;
  }
}
