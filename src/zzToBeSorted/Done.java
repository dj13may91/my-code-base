package zzToBeSorted;/*
A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to color it according to some instructions. Specifically, each cell can be either black or white, which we will represent as 'B' for black and 'W' for white.

+------------+
| W  W  W  W |
| B  W  W  W |
| B  W  B  B |
| W  W  B  W |
| B  B  W  W |
+------------+

For each row and column, the instructions give the lengths of contiguous runs of black ('B') cells. For example, the instructions for one row of [ 2, 1 ] indicate that there must be a run of two black cells, followed later by another run of one black cell, and the rest of the row filled with white cells.

These are valid solutions: [ W, B, B, W, B ] and [ B, B, W, W, B ] and also [ B, B, W, B, W ]
This is not valid: [ W, B, W, B, B ] since the runs are not in the correct order.
This is not valid: [ W, B, B, B, W ] since the two runs of Bs are not separated by Ws.

Your job is to write a function to validate a possible solution against a set of instructions. Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of instructions match.

Example instructions #1

matrix1 = [[ W, W, W, W ],
           [ B, W, W, W ],
           [ B, W, B, B ], -> [1, 2]
           [ W, W, B, W ],
           [ B, B, W, W ]]
rows1_1    =  [], [1], [1,2], [1], [2]
columns1_1 =  [2,1], [1], [2], [1]

[2,1] = 2 black tiles, seperates by N number of white tiles, followed by 1 white tile

validateNonogram(matrix1, rows1_1, columns1_1) => True

Example solution matrix:
matrix1 ->
                                   row
                +------------+     instructions
                | W  W  W  W | <-- []
                | B  W  W  W | <-- [1]
                | B  W  B  B | <-- [1,2]
                | W  W  B  W | <-- [1]
                | B  B  W  W | <-- [2]
                +------------+
                  ^  ^  ^  ^
                  |  |  |  |
  column       [2,1] | [2] |
  instructions      [1]   [1]


Example instructions #2

(same matrix as above)
rows1_2    =  [], [], [1], [1], [1,1]
columns1_2 =  [2], [1], [2], [1]
validateNonogram(matrix1, rows1_2, columns1_2) => False
//
pseudo
for(int rows[] : allRows){
  // [1,4,2,7,5]
  if(length of curr row == 0){
    check row for zero BT
  }
  else if(length of curr row == 1){
    check row for 1 BT => break at 1
  }
  else { [1,2, 4,5,1]
    for(int inst : intstructions){
      1 find inst BT = inst in curr row; //1bt : wt -> 2bt
      2 check for atleast 1 WT
    }
  }
}

public boolean checkValidTiles(){

}

//


The second and third rows and the first column do not match their respective instructions.

Example instructions #3

(same matrix as above)
rows1_3    = [], [1], [3], [1], [2]
columns1_3 = [3], [1], [2], [1]
validateNonogram(matrix1, rows1_3, columns1_3) => False

The third row and the first column do not match their respective instructions.

Example instructions #4

(same matrix as above)
rows1_4    =  [], [1,1], [1,2], [1], [2]
columns1_4 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_4, columns1_4) => False

The second row does not match the respective instructions

Example instructions #5

matrix2 = [
 [ W, W ],
 [ B, B ],
 [ B, B ],
 [ W, B ]
]
rows2_1    = [], [2], [2], [1]
columns2_1 = [1, 1], [3]
validateNonogram(matrix2, rows2_1, columns2_1) => False

The black cells in the first column are not separated by white cells.

Example instructions #6

(same matrix as above)
rows2_2    = [], [2], [2], [1]
columns2_2 = [3], [3]
validateNonogram(matrix2, rows2_2, columns2_2) => False

The first column has the wrong number of black cells.

Example instructions #7

(same matrix as above)
rows2_3    = [], [], [], []
columns2_3 = [], []
validateNonogram(matrix2, rows2_3, columns2_3) => False

All of the instructions are empty

All Test Cases:
validateNonogram(matrix1, rows1_1, columns1_1) => True
validateNonogram(matrix1, rows1_2, columns1_2) => False
validateNonogram(matrix1, rows1_3, columns1_3) => False
validateNonogram(matrix1, rows1_4, columns1_4) => False
validateNonogram(matrix2, rows2_1, columns2_1) => False
validateNonogram(matrix2, rows2_2, columns2_2) => False
validateNonogram(matrix2, rows2_3, columns2_3) => False

n: number of rows in the matrix
m: number of columns in the matrix
*/

import java.io.*;
import java.util.*;

public class Done {
    public static void main(String[] argv) {

        char[][] matrix1 = {
                {'W','W','W','W'},
                {'B','W','W','W'},
                {'B','W','B','B'},
                {'W','W','B','W'},
                {'B','B','W','W'}};

        int[][] rows1_1 = {{},{1},{1,2},{1},{2}};
        int[][] columns1_1 = {{2,1},{1},{2},{1}};

        int[][] rows1_2 = {{},{},{1},{1},{1,1}};
        int[][] columns1_2 = {{2},{1},{2},{1}};

        int[][] rows1_3 = {{},{1},{3},{1},{2}};
        int[][] columns1_3 = {{3},{1},{2},{1}};

        int[][] rows1_4 = {{},{1,1},{1,2},{1},{2}};
        int[][] columns1_4 = {{2,1},{1},{2},{1}};

        char[][] matrix2 = {
                {'W','W'},
                {'B','B'},
                {'B','B'},
                {'W','B'}};

        int[][] rows2_1 = {{},{2},{2},{1}};
        int[][] columns2_1 = {{1,1},{3}};

        int[][] rows2_2 = {{},{2},{2},{1}};
        int[][] columns2_2 = {{3},{3}};

        int[][] rows2_3 = {{},{},{},{}};
        int[][] columns2_3 = {{},{}};

    }

    public static boolean isSudokuValid(int[][] grid){
        if(grid.length == 1 && grid[0][0] == 1){
            return true;
        }


        // S = O(n)
        for(int i=0; i< grid.length; i++){
            int row[] = new int[grid.length];
            int col[] = new int[grid.length];
            for(int j=0; j< grid.length; j++){
                if(grid[i][j] < 1 || grid[i][j] > grid.length){ //out of bound number check
                    return false;
                }

                if(row[grid[i][j] - 1] != 0){
                    System.out.println("row duplciate num " + row[j] + "; i:" + i + "; j:" + j);
                    return false;
                } // duplicate number
                row[grid[i][j] - 1] =  grid[i][j];

                if(col[grid[j][i] - 1] != 0){
                    System.out.println("col duplciate num " + col[j]);
                    return false;
                }
                col[grid[j][i] - 1] = grid[j][i];
            }
        }

        // for(int i=0; i< grid.length; i++){
        //   int col[] = new int[grid.length];
        //   for(int j=0; j< grid.length; j++){
        //     // if(grid[j][i] < 1 || grid[j][i] > grid.length){
        //     //   return false;
        //     // }

        //     if(col[grid[j][i] - 1] != 0){
        //       System.out.println("col duplciate num " + col[j]);
        //       return false;
        //     }
        //     col[grid[j][i] - 1] = grid[j][i];
        //   }
        // }
        return true;
    }

}
