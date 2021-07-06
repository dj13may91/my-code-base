package leetcode;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String strs[] = {"flower", "flow", "flowlon"};
    System.out.println("and: " + longestCommonPrefix(strs));
  }

  public static String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }

    if (strs.length == 1) {
      return strs[0];
    }
    String commonPrefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      if (commonPrefix.length() == 0 || strs[i].length() == 0) {
        return "";
      }
      int count = 0;
      while (commonPrefix.charAt(count) == strs[i].charAt(count)) {
        count++;
        if (strs[i].length() < count + 1 || commonPrefix.length() < count + 1) {
          break;
        }
      }
      commonPrefix = strs[0].substring(0, count);
    }
    return commonPrefix;
  }
}


/*
* Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/
