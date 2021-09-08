package dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// get largest string where there can be max k consecutive characters
// like axxzzx with 2 max , return zzxxax
// if not possible, then drop required no. of characters
//example: abbccbbb return ccbbabb
public class LargestStringKConsecutive {

  public static void main(String[] args) {
    System.out.println(getLargestString("abbccbbb", 2));
  }

  public static String getLargestString(String s, int k) {
    // Write your code here
    StringBuilder sb = new StringBuilder();
    int[] arr = new int[26];
    for (char ch : s.toCharArray()) {
      arr[ch - 'a']++;
    }
    System.out.println(Arrays.toString(arr));
    Map<Integer, Character> map = new HashMap<>();
    for (char ch = 'a'; ch <= 'z'; ch++) {
      map.put(ch - 'a', ch);
    }
    int currIndex = 25;
    int lastIndex = currIndex;
    int count = 0;
    while (true) {
      while (count < k & arr[currIndex] > 0) {
        sb.append(map.get(currIndex));
        arr[currIndex]--;
        count++;
      }
      count = 0;
      lastIndex = currIndex;
      currIndex = getCurrIndex(currIndex - 1, arr);
      if (currIndex == -1) {
        break;
      }
      if (arr[lastIndex] != 0) {
        sb.append(map.get(currIndex));
        arr[currIndex]--;
        currIndex = lastIndex;
      }
    }

    return sb.toString();
  }

  private static int getCurrIndex(int currIndex, int[] arr) {
    while (currIndex >= 0 && arr[currIndex] == 0) {
      currIndex--;
    }
    return currIndex;
  }
}
