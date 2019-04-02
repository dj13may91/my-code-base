package Competitive_programming;

/**
 * Google interview :
 * MAXIMUM points that can be collected in an N*M matrix
 * You can move either right or down
 * Start from [0,0]
 */

public class MaxSumInMatrix {
    static class Visits {
        int max;
        boolean isVisited;

        Visits() {
            this.max = 0;
            this.isVisited = false;
        }

    }

    private static Visits visited[][];

    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 100},
                {4, 100, 6},
                {7, 8, 9}
        };

        visited = new Visits[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                visited[i][j] = new Visits();
    }

    public static int getMaxPoints(int array[][]) {
        if (array.length == 1 && array[0].length == 1)
            return array[0][0];

        int startRight = collectMaxPoints(0, 1, array);
        int startDown = collectMaxPoints(1, 0, array);
        return array[0][0] + (startRight > startDown ? startRight : startDown);
    }


    public static int collectMaxPoints(int x, int y, int arr[][]) {
        if (x == arr.length || y == arr[0].length) {
            return 0;
        }

        if (visited[x][y].isVisited)
            return visited[x][y].max;
        // increase visit of each index by 1
        int startRight = arr[x][y] + collectMaxPoints(x + 1, y, arr);
        int startDown = arr[x][y] + collectMaxPoints(x, y + 1, arr);
        visited[x][y].max = startRight > startDown ? startRight : startDown;
        visited[x][y].isVisited = true;
        return visited[x][y].max;
    }

}
