package dynamic_programming;

import java.util.Arrays;

/**
 * Imagine a MxN grid where we can move either right or down at any point in time.
 * Our home is located at the bottom right corner of the grid.
 * Find number of unique ways to reach home.
 */
public class OnTheWayHome {
    /**
     * Solution: numWays(i, j) = numWays(i+1, j) + numWays(i, j+1)
     */

    public static int numWays(int m, int n) {
        int grid[][] = new int[m] [n];

        // base cases
        for (int i = 0; i < m-1; i++) {
            grid[i][n-1] = 1;
        }
        for (int i = 0; i < n-1; i++) {
            grid[m-1][i] = 1;
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0 ; j--) {
                grid[i][j] = grid[i][j+1] + grid[i+1][j];
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        int M = 4;
        int N = 3;
        System.out.println("Number of ways " + numWays(M, N));
    }
}
