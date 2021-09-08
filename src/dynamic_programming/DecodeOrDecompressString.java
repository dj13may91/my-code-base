package dynamic_programming;

import java.util.Stack;

public class DecodeOrDecompressString {

  /*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
* Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
* For example, there won't be input like 3a or 2[4].

Example 1:
	Input: s = "3[a]20[bc]"
	Output: "aaabcbc"


Example 2:
	Input: s = "3[a2[c]]"
	Output: "accaccacc"

Example 3:
	Input: s = "2[abc]3[cd]ef"
	Output: "abcabccdcdcdef"

Example 4:
	Input: s = "abc3[cd]xyz"
	Output: "abccdcdcdxyz"
*/
  public static void main(String[] args) {
    String s = "3[a]10[b]";
    getString(s);
  }

  public static void getString(String s) {
    Stack<String> charSet = new Stack<>();
    Stack<Integer> intSet = new Stack<>();
    String open = "[";
    String close = "]";
    for (int i = 0; i < s.length(); i++) {
      if (checkNum(s.charAt(i))) {
        int num = Integer.parseInt(s.charAt(i) + "");
        while (checkNum(s.charAt(i+1))) {
          i++;
          num = num * 10 + Integer.parseInt(s.charAt(i) + "");
        }
        intSet.add(num);
      } else if ((s.charAt(i) + "").equals(close)) {
        StringBuilder sb = new StringBuilder();
        while(!charSet.peek().equals(open)){
          sb.insert(0, charSet.pop());
        }
        charSet.pop(); // remove [ bracket now
        int multiplier = intSet.pop();
        for(int x=0; x< multiplier; x++){
          charSet.add(sb.toString());
        }
      }else {
        charSet.add(s.charAt(i) + "");
      }
    }
    StringBuilder sb = new StringBuilder();
    for(String str : charSet){
      sb.append(str);
    }

    System.out.println(sb.toString());
  }

  private static boolean checkNum(char charAt) {
    return '0' <= charAt && '9' >= charAt;
  }
}






















