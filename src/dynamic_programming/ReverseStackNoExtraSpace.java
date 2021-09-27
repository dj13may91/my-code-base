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
    } else {
      int x = s.pop();
      insetAtEnd(val);
      s.push(x);
    }
  }

  public static void reverse() {
    if (s.size() > 0) {
      int val = s.pop();
      reverse();
      insetAtEnd(val);
    }// n + n2 + n
  }
}
