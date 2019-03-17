/**
 * Obstacles for the Queen
 * A queen in the game of chess is the most powerful piece as it can move horizontally,
 * vertically and diagonally with no limit on the number of squares.
 * You are given an _nXn_ chess board and a position where the queen is placed as (r,c)
 * where r represents the row number of the square and c represents the column number of the square.
 * Rows are numbers from 1 to n starting from bottom and columns are numbered from 1 to n starting from left.
 * So the bottom left square is (1,1). Find the number of places where an obstacle can be placed such that the
 * number of moves of the queen remain the same as before.
 * Input Format
 * The input contains:
 * The first line contains t test cases.
 * The next t lines contains
 * n, which is the size of the chessboard, followed by a space and then (r,c) which gives the position of the queen
 * Output Format
 * The output contains t lines each of which contain the number of squares where the obstacle can be placed.
 * Constraints
 * 1 <= t <= 10000
 * 4 <= n <= 10000
 * Sample Input
 * 2
 * 4 (1,1)
 * 5 (3,4)
 * Sample Output
 * 7
 * 11
 * Explanation
 * For the 1st test case, total number of squares on the board are 16 and placing the queen at (1,1) allows 9 moves.Therefore, the obstacle can be placed in 7 squares.
 * For the 2nd test case, total number of squares on the board are 25 and placing the queen at (3,4) allows 14 moves. Therefore, the obstacle can be placed in 11 squares.
 * Environment
 * Read from STDIN and write to STDOUT.
 * Please check the sample program below which prints the sum of two numbers received as input
 * 2
 * 4 (1,1) -> 7
 * 5 (3,4) -> 11
 */
package Competitive_programming;

import java.util.Scanner;

public class ObstaclesForQueen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        while (testCases > 0) {
            testCases--;
            String newMatrixQueenDetails[] = scanner.nextLine().split(" ");
            int matrixSize = Integer.parseInt(newMatrixQueenDetails[0]);
            char positionArr[] = newMatrixQueenDetails[1].toCharArray();
            positionArr[0] = ',';
            positionArr[positionArr.length - 1] = ',';
            int queenPositionX = Integer.parseInt(String.valueOf(positionArr).trim().split(",")[1]);
            int queenPositionY = Integer.parseInt(String.valueOf(positionArr).split(",")[2]);
            System.out.println(getFreePositions(matrixSize, queenPositionX, queenPositionY));
        }
    }

    private static int getFreePositions(int matrixSize, int queenPositionX, int queenPositionY) {
        int moves = 0;
//        int leftMoves = 0;
        int currX = queenPositionX - 1;
        while (currX >= 1) {
            currX--;
            moves++;
        }

//        int rightMoves = 0;
        currX = queenPositionX + 1;
        while (currX <= matrixSize) {
            moves++;
            currX++;
        }

        int currY = queenPositionY - 1;
//        int downMoves = 0;
        while (currY >= 1) {
            currY--;
            moves++;
        }

//        int upMoves = 0;
        currY = queenPositionY + 1;
        while (currY <= matrixSize) {
            currY++;
            moves++;
        }

//        int diagonalUpLeft = 0;
        currX = queenPositionX - 1;
        currY = queenPositionY + 1;
        while (currX >= 1 && currY <= matrixSize) {
            currX--;
            currY++;
            moves++;
        }

//        int diagonalDownRight = 0;
        currX = queenPositionX + 1;
        currY = queenPositionY - 1;
        while (currY >= 1 && currX <= matrixSize) {
            currX++;
            currY--;
            moves++;
        }


        /**
         p  q   r   s   t   u
         todo:   a  b   c   d   e   v
         13	14	15	16  f   w
         10	11	12	13  g   x
         5	6	7	8   h   y
         1	2	3	4   i   z
         */

//        int diagonalUpRight = 0;
        currX = queenPositionX + 1;
        currY = queenPositionY + 1;
        while (currY <= matrixSize && currX <= matrixSize) {
            currX++;
            currY++;
            moves++;
        }

//        int diagonalDownLeft = 0;
        currX = queenPositionX - 1;
        currY = queenPositionY - 1;
        while (currY >= 1 && currX >= 1) {
            currX--;
            currY--;
            moves++;
        }

        return (matrixSize * matrixSize) - (moves);
    }
}
