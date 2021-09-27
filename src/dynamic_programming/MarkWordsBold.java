package dynamic_programming;

import java.util.Arrays;

public class MarkWordsBold {

  /*
  You are given a string s and an array of strings words. You should add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in words. If two such substrings overlap, you should wrap them together with only one pair of closed bold-tag. If two substrings wrapped by bold tags are consecutive, you should combine them.
Return s after adding the bold tags.

Example 1:
Input: s = "abcxyz123", words = ["abc","123"]
Output: "<b>abc</b>xyz<b>123</b>"

Example 2:
Input: s = "aaabbcc", words = ["aaa","bc","aab"]
Output: "<b>aaabbc</b>c"
Example 3:
s = "aaaxxx", words = ["aaa","xxx","bc"]
<b>aaaxxx</b>




------

Input: s = "aaabbcc" : L, words = ["aaa","bc","aab"] N
Output: "<b>aaabbc</b>c"  =>
Aaa :  0-2,   1-3  => 0-3 => 0-4 => 0-6
Bc : 5-6   ;  aab : 2-4
Map<Start, end> => 0-2  ; 5-6 ; 2-4
arr[L] => [0,0,0,0,0,0,0] => [B111B0B1111B]

  */
  public static void main(String[] args) {
    String s = "aaaabbcc";
    String[] words = {"yz", "xxx", "zz"};
    int[] arr = new int[s.length()];
    for (String word : words) {
      search(arr, s, word);
    }
    System.out.println(Arrays.toString(arr));
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length;) {
      if (arr[i] == 1) {
        sb.append("<b>");
        while (i < arr.length && arr[i] != 0) {
          sb.append(s.charAt(i)); //3
          i++;
        }
        sb.append("</b>");
      } else {
        sb.append(s.charAt(i));
        i++;
      }
    }
    System.out.println(sb);
  }

  public static void search(int[] arr, String s, String word) {
    int index = s.indexOf(word);
    if (index != -1) {
      while (index != -1) {
        for (int i = 0; i < word.length(); i++) {
          arr[index + i] = 1;
        }
        index = s.indexOf(word, index + 1);
      }
    }
  }

}
