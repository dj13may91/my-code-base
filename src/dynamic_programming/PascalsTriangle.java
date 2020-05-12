package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

  public static void main(String[] args) {
    int size = 10;
    List<List<Integer>> pascalsTriangle = new ArrayList<>();
    List<Integer> firstRow = new ArrayList<>(1);
    firstRow.add(1);
    pascalsTriangle.add(firstRow);
    for (int i = 1; i < size; i++) {
      List<Integer> nextRow = new ArrayList<>(i + 1);
      for (int j = 0; j <= i; j++) {
        addFromPreviousLine(j-1, j , pascalsTriangle.get(i-1), nextRow);
      }
      pascalsTriangle.add(nextRow);
    }
    for (List<Integer> list: pascalsTriangle) {
      System.out.println(list);
    }
  }


  private static void addFromPreviousLine(int n, int m, List<Integer> previous, List<Integer> newList) {
    if (n < 0) {
      newList.add(previous.get(m));
    } else if (m >= previous.size()) {
      newList.add(previous.get(n));
    } else {
      newList.add(previous.get(n) + previous.get(m));
    }
  }
}
