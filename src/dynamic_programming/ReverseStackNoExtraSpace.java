package dynamic_programming;

import java.util.Stack;

public class ReverseStackNoExtraSpace {

  static Stack<Integer> s = new Stack<>();

  public static void main(String[] args) {
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    System.out.println(s);
    reverse();
    System.out.println(s);
  }

  public static void insetAtEnd(int val) { // 1 + 2 + 3 + ... n => n(n+1)
    System.out.println("val : " + val + " " + s);
    if (s.isEmpty()) {
      s.push(val);
      System.out.println("empty push: " + val);
    } else {
      int x = s.pop();
      System.out.println("end pop: " + x);
      insetAtEnd(val);
      s.push(x);
      System.out.println("reverse pop push: " + x);
    }
  }

  public static void reverse() {
    if (s.size() > 0) {
      int val = s.pop();
      System.out.println("reverse pop : " + val);
      reverse();
      insetAtEnd(val);
    }// n + n2 + n
  }
}
