package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxBitString {

  /*
  Get maximum String (lexographically) maintaining a good bit string
  A string is a good bit string if
  a. count of 0 == 1
  b. at any index count of 1 >= 0
  Example : 101100 => max = 110010 by swapping 10 and 1100
  Swap good bits.
   */
  public static void main(String[] args) {
    String s = "1010101100";
    System.out.println(largestMagical(s));
  }

  public static String largestMagical(String binString) {
    Map<Integer, List<GoodString>> map = new HashMap<>();
    for (int i = 0; i < binString.length(); i++) {
      map.put(i, new ArrayList<>());
      if (binString.charAt(i) != '0') {
        String s = binString.substring(i);
        for (int j = 0; j < s.length() - 1; j = j + 2) {
          String currGoodString = s.substring(0, j + 2);
          System.out.println(currGoodString);
          if (checkPrefix(currGoodString) && checkGoodString(currGoodString)) {
            List<GoodString> goodStringList = map.get(i);
            goodStringList.add(new GoodString(i, i + j + 1));
            map.put(i, goodStringList);
          }
        }
      }
    }
    System.out.println(map);

    String max = binString;
    for (int i = 0; i < binString.length(); i++) {
      for (GoodString from : map.get(i)) {
        if (map.get(from.end + 1) != null) {
          for (GoodString to : map.get(from.end + 1)) {
            String currMax = swapStrings(from, to, binString);
            if (currMax.compareTo(max) > 0) {
              max = currMax;
            }
          }
        }
      }
    }

    return max;
  }

  public static String swapStrings(GoodString a, GoodString b, String s) {
    StringBuilder sb = new StringBuilder(s);
    int start = a.start;
    for (int i = b.start; i <= b.end; i++) {
      sb.setCharAt(start++, s.charAt(i));
    }
    for (int i = a.start; i <= a.end; i++) {
      sb.setCharAt(start++, s.charAt(i));
    }
    return sb.toString();
  }

  public static boolean checkGoodString(String currString) {
    int ones = 0;
    for (int i = 0; i < currString.length(); i++) {
      ones = currString.charAt(i) == '1' ? ones + 1 : ones - 1;
    }
    return ones == 0;
  }

  public static boolean checkPrefix(String currString) {
    int ones = 0;
    for (int i = 0; i < currString.length(); i++) {
      if (currString.charAt(i) == '1') {
        ones++;
      } else {
        ones--;
      }
      if (ones < 0) {
        return false;
      }
    }
    return true;
  }

  static class GoodString {

    int start;
    int end;

    public GoodString(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "GoodString{" + "start=" + start + ", end=" + end + '}';
    }
  }
}
