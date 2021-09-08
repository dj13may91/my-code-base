package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesisGeneration {
  /*
  Implement an algorithm to print all valid (i.e., properly opened and closed) combinations of n pairs of parentheses
  Input: n=1
Output: ()

Input: n=2
Output: ()(), (())
*/

  private static final List<String> valid = new ArrayList<>();

  public static void main(String[] args) {
    int n = 3;
    createParenthesis(n, n, "");
    System.out.println(valid);
  }

  public static void createParenthesis(int open, int close, String curr) {
    if (open == 0) {
      StringBuilder currBuilder = new StringBuilder(curr);
      while (close != 0) {
        currBuilder.append(")");
        close--;
      }
      curr = currBuilder.toString();
      valid.add(curr);
      return;
    }
    if (open < close) {
      createParenthesis(open, close - 1, curr + ")");
    }
    createParenthesis(open - 1, close, curr + "(");
  }
}




/*
tournament : 16 teams =>
1. 16/2 => v/2 => v1/2 => == 1
2. a won against b
abcd => a d => a =>

ia ib ic id

ab cd
a c
a

I A S P => I vs A => I  =>
S vs P => S
==> I vs S =>

 == 2^n
* */

















