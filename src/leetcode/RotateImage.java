package leetcode;

public class RotateImage {

  public static void main(String[] args) {
    int[][] matrix =
        {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    rotate(matrix);
  }

  public static void rotate(int[][] matrix) {
    //transpose
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j <= i; j++) {
        swap(matrix, i, j);
      }
    }

    System.out.println("__________________________________");
    //reverse
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - 1 - j];
        matrix[i][matrix.length - 1 - j] = temp;
        print(matrix);
      }
    }
  }

  public static void print(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void swap(int[][] matrix, int i, int j) {
    if (i == j) {
      return;
    }
    matrix[i][j] = matrix[i][j] + matrix[j][i];
    matrix[j][i] = matrix[i][j] - matrix[j][i];
    matrix[i][j] = matrix[i][j] - matrix[j][i];
    print(matrix);
  }
}
