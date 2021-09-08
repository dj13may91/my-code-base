package Competitive_programming;

import java.util.Arrays;

public class MaxSumInMatrix_2 {

  static int[][] arr = {
      {1, 2, 100},
      {4, 100, 6},
      {7, 8, 9},
      {100, 11, 4}
  };
  static int[][] sum = new int[arr.length][];
  static boolean[][] visited = new boolean[arr.length][];

  public static void main(String[] args) {
    for (int i = 0; i < arr.length; i++) {
      sum[i] = new int[arr[i].length];
      visited[i] = new boolean[arr[i].length];
    }
    int max = arr[0][0] + Math.max(getMax(1, 0), getMax(0, 1));
    System.out.println(max);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(sum[i]));
    }
  }

  private static int getMax(int i, int j) {
    if (i == arr.length || j == arr[i].length) {
      return 0;
    }
    if (visited[i][j]) {
      System.out.println("visited: " + i + ", " + j);
      return sum[i][j];
    }
    visited[i][j] = true;
    sum[i][j] = arr[i][j] + Math.max(getMax(i + 1, j), getMax(i, j + 1));
    return sum[i][j];
  }
}
