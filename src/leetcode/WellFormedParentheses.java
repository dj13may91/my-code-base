package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WellFormedParentheses {

  public static void main(String[] args) {
    System.out.println(generateParenthesis(3));
  }

  public static List<String> generateParenthesis(int n) {
    List<String> patterns = new ArrayList<>();
    generate(n, n, "", patterns);
    return patterns;
  }

  public static void generate(int open, int close, String pattern,
      List<String> patterns) {
    if (open == 0 && close == 0) {
      patterns.add(pattern);
    } else if (open == 0 && close > 0) {
      StringBuilder patternBuilder = new StringBuilder(pattern);
      while (close-- > 0) {
        patternBuilder.append(')');
      }
      pattern = patternBuilder.toString();
      patterns.add(pattern);
    } else if (open == close) {
      generate(open - 1, close, pattern + '(', patterns);
    } else if (open < close) {
      generate(open - 1, close, pattern + '(', patterns);
      generate(open, close - 1, pattern + ')', patterns);
    }
  }

//  public static List<String> generateParenthesis(int n) {
//    if(n == 1){
//      return Collections.singletonList("()");
//    }else if (n==0){
//      return new ArrayList<>();
//    }
//    Queue<Character> openQueue = new ArrayDeque<>();
//    Queue<Character> closeQueue = new ArrayDeque<>();
//    char open = '(';
//    char close = ')';
//    for (int i = 0; i < n; i++) {
//      openQueue.add(open);
//      closeQueue.add(close);
//    }
//    Set<String> patterns = new HashSet<>();
//    popAndAppend(openQueue, closeQueue, "", patterns);
//    return new ArrayList<>(patterns);
//  }
//
//  public static void popAndAppend(Queue<Character> open, Queue<Character> close, String pattern,
//      Set<String> patterns) {
//    if (open.isEmpty() && close.isEmpty()) {
//      patterns.add(pattern);
//    } else if (open.isEmpty()) {
//      StringBuilder patternBuilder = new StringBuilder(pattern);
//      while (!close.isEmpty()) {
//        patternBuilder.append(close.poll());
//      }
//      pattern = patternBuilder.toString();
//      patterns.add(pattern);
//    } else if (open.size() == close.size()) {
//      pattern = pattern + open.poll();
//      popAndAppend(new ArrayDeque<>(open), new ArrayDeque<>(close), pattern, patterns);
//    } else if (open.size() < close.size()) {
//      Queue<Character> openCopy = new ArrayDeque<>(open);
//      Queue<Character> closeCopy = new ArrayDeque<>(close);
//      String p1 = pattern + open.poll();
//      popAndAppend(new ArrayDeque<>(open), closeCopy, p1, patterns);
//      String p2 = pattern + close.poll();
//      popAndAppend(openCopy, new ArrayDeque<>(close), p2, patterns);
//    }
//  }
}
