package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralPrint {

  public static void main(String[] args) {
    int[][] matrix =
//        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    System.out.println(spiralOrder(matrix));
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    moveRight(ans, 0, 0, (matrix.length - 1), (matrix[0].length - 1), matrix);
    return ans;
  }

  public static void moveRight(List<Integer> ans, int rMin, int cMin, int rMax,
      int cMax, int[][] matrix) {
    int j = cMin;
    while (j <= cMax) {
      ans.add(matrix[rMin][j]);
      j++;
    }
    if (moveInwards(rMin + 1, cMin, rMax, cMax)) {
      moveDown(ans, rMin, cMin, rMax, cMax, matrix);
    }
  }

  public static void moveDown(List<Integer> ans, int rMin, int cMin, int rMax, int cMax,
      int[][] matrix) {
    int i = rMin + 1;
    while (i <= rMax) {
      ans.add(matrix[i][cMax]);
      i++;
    }
    if (moveInwards(rMin, cMin, rMax, cMax - 1)) {
      moveLeft(ans, rMin, cMin, rMax, cMax, matrix);
    }
  }

  public static void moveLeft(List<Integer> ans, int rMin, int cMin, int rMax, int cMax,
      int[][] matrix) {
    int j = cMax - 1;
    while (j >= cMin) {
      ans.add(matrix[rMax][j]);
      j--;
    }
    if (moveInwards(rMin, cMin, rMax - 1, cMax)) {
      moveUp(ans, rMin, cMin, rMax, cMax, matrix);
    }
  }

  public static void moveUp(List<Integer> ans, int rMin, int cMin, int rMax, int cMax,
      int[][] matrix) {
    int i = rMax - 1;
    while (i >= rMin + 1) {
      ans.add(matrix[i][cMin]);
      i--;
    }
    rMin++;
    cMin++;
    cMax--;
    rMax--;
    if (moveInwards(rMin, cMin, rMax, cMax)) {
      moveRight(ans, rMin, cMin, rMax, cMax, matrix);
    }
  }

  public static boolean moveInwards(int rMin, int cMin, int rMax, int cMax) {
//    System.out.println("=> " + cMin + " " + rMin + " " + cMax + " " + rMax);
    return (rMax >= rMin && cMax >= cMin);
  }
}
