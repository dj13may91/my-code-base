package leetcode;

// https://leetcode.com/problems/longest-valid-parentheses/
//Given a string containing just the characters '(' and ')',
//    find the length of the longest valid (well-formed) parentheses substring.
//
//    Example 1:
//    Input: s = "(()"
//    Output: 2
//    Explanation: The longest valid parentheses substring is "()".
public class LongestValidParenthesis {

  public static void main(String[] args) {
    String s = "()()(()))(";
    System.out.println(longestValidParentheses(s));
  }

  public static int longestValidParentheses(String s) {
    return Math.max(leftToRightScan(s), rightToLeftScan(s));
  }

  public static int leftToRightScan(String s) {
    int leftCount = 0;
    int rightCount = 0;
    int max = 0;
    char open = '(';
    for (char ch : s.toCharArray()) {
      if (ch == open) {
        leftCount++;
      } else {
        rightCount++;
      }
      if (leftCount == rightCount) {
        max = Math.max(leftCount, max);
      } else if (leftCount < rightCount) {
        leftCount = 0;
        rightCount = 0;
      }
    }
    return max * 2;
  }

  public static int rightToLeftScan(String s) {
    int leftCount = 0;
    int rightCount = 0;
    int max = 0;
    char close = ')';
    char[] arr = s.toCharArray();
    for (int i = s.length() - 1; i >= 0; i--) {
      if(arr[i] == close){
        rightCount++;
      }else {
        leftCount++;
      }
      if(leftCount == rightCount){
        max = Math.max(leftCount, max);
      }else if (leftCount > rightCount) {
        leftCount = 0;
        rightCount = 0;
      }
    }
    return max*2;
  }
}
