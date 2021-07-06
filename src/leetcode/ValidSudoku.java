package leetcode;

public class ValidSudoku {

  public static void main(String[] args) {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '3', '.', '.', '8', '.', '.', '7', '9'}
    };
    System.out.println(isValidSudoku(board));
  }

  public static boolean isValidSudoku(char[][] board) {
    return checkColumns(board) && checkRows(board) && validate3X3blocks(board);
  }

  private static boolean checkRows(char[][] board) {
    for (int i = 0; i < 9; i++) {
      boolean[] rowCounter = new boolean[9];
      for (int j = 0; j < 9; j++) {
//        System.out.print(board[i][j] + " ");
        if (board[i][j] != '.') {
          int rowIndex = board[i][j] - '0' - 1;
          if (rowCounter[rowIndex]) {
//            System.out.println("\n found at row " + i + ", " + j + " : " + board[i][j]);
            return false;
          }
          rowCounter[rowIndex] = true;
        }
      }
//      System.out.println();
    }
    return true;
  }

  private static boolean checkColumns(char[][] board) {
    for (int i = 0; i < 9; i++) {
      boolean[] counter = new boolean[9];
      for (int j = 0; j < 9; j++) {
//        System.out.print(board[j][i] + " ");
        if (board[j][i] != '.') {
          int index = board[j][i] - '0' - 1;
          if (counter[index]) {
//            System.out.println("\n found at row " + j + ", " + i + " : " + board[i][j]);
            return false;
          }
          counter[index] = true;
        }
      }
//      System.out.println();
    }
    return true;
  }

  private static boolean validate3X3blocks(char[][] board) {
    for (int iInc = 0; iInc < 9; iInc = iInc + 3) {
      for (int jInc = 0; jInc < 9; jInc = jInc + 3) {
        boolean[] numCounter = new boolean[9];
        for (int i = iInc; i < 3 + iInc; i++) {
          for (int j = jInc; j < 3 + jInc; j++) {
//            System.out.print(board[i][j] + " ");
            if (board[i][j] != '.') {
              int index = board[i][j] - '0' - 1;
              if (!numCounter[index]) {
                numCounter[index] = true;
              } else {
//                System.out.println("\nfound at " + i + ", " + j + " : " + board[i][j]);
                return false;
              }
            }
          }
//          System.out.print(" | ");
        }
//        System.out.println();
      }
    }
    return true;
  }
}
