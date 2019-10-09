package Competitive_programming;


import java.util.Arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral
 * order. Input: 3 Output: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class SpiralMatrix {

  private int[][] matrix;
  private int size = 5;

  public static void main(String[] args) {
    SpiralMatrix spiralMatrix = new SpiralMatrix();
    spiralMatrix.matrix = new int[spiralMatrix.size][spiralMatrix.size];
    spiralMatrix.moveRight(0, 0, 1);
    for(int i=0; i< spiralMatrix.size; i++){
      System.out.println(Arrays.toString(spiralMatrix.matrix[i]));
    }
  }

  private void moveRight(int row, int col, int currNum) {
    if(currNum == (size*size)){
      matrix[row][col] = currNum;
      return;
    }
    while (col != size - 1 || matrix[row][col] == 0) {
      matrix[row][col] = currNum++;
      if ((col + 1 != size) && matrix[row][col + 1] == 0) {
        col++;
      } else {
        break;
      }
    }
    moveDown(++row, col, currNum);
  }

  private void moveDown(int row, int col, int currNum) {
    if(currNum == (size*size)){
      return;
    }
    while (row != size - 1 || matrix[row][col] == 0) {
      matrix[row][col] = currNum++;
      if ((row + 1 != size) && matrix[row + 1][col] == 0) {
        row++;
      } else {
        break;
      }
    }
    moveLeft(row, --col, currNum);
  }

  private void moveLeft(int row, int col, int currNum) {
    if(currNum == (size*size)){
      matrix[row][col] = currNum;
      return;
    }
    while (col != 0 || matrix[row][col] == 0) {
      matrix[row][col] = currNum++;
      if ((col - 1 != -1) && matrix[row][col - 1] == 0) {
        col--;
      } else {
        break;
      }
    }
    moveUp(--row, col, currNum);
  }

  private void moveUp(int row, int col, int currNum) {
    if(currNum == (size*size)){
      return;
    }
    while (row != 0 || matrix[row][col] == 0) {
      matrix[row][col] = currNum++;
      if ((row - 1 != -1) && matrix[row - 1][col] == 0) {
        row--;
      } else {
        break;
      }
    }
    moveRight(row, ++col, currNum);
  }
}
