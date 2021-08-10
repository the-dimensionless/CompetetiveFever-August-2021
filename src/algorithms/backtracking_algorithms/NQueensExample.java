package algorithms.backtracking_algorithms;

import sun.jvm.hotspot.tools.SysPropsDumper;

import java.util.stream.IntStream;

public class NQueensExample {
    private int[][] table;
    private int N;


    public NQueensExample(int N) {
        this.N = N;
        this.table = new int[N][N];
    }

    public void solve() {
        if (setQueens(0)) {
            printQueens();
        } else {
            System.out.println("No Solution. . .");
        }
    }

    private void printQueens() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {
                if (table[i][j] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" _ ");
                }
            }
            System.out.println();
        }
    }

    private boolean setQueens(int columnIndex) {
        if (columnIndex == N) {
            return true;
        }
        for (int i = 0; i < N; ++i) {
            if (isPlaceValid(i, columnIndex)) {
                table[i][columnIndex] = 1;
                if (setQueens(columnIndex + 1)) {
                    return  true;
                }

                // Backtracking
                table[i][columnIndex] = 0;
            }

        }
        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        for (int i = 0; i < colIndex; i++) {
            if (table[rowIndex][i] == 1)
                return false;
        }

        for (int i = rowIndex, j = colIndex; i >= 0 && j>= 0; i--, j--) {
            if (table[i][j] == 1)
                return false;
        }
        for (int i = rowIndex, j=colIndex; i < N && j>=0; i++, j--) {
            if (table[i][j] == 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        O(N^N) = O (N!) => brute force
//        O(2^N) => backtracking (still slow for large N like 100, 1000)

        IntStream.range(1, 9).forEach((i) -> {
            System.out.println("For "+i+" Queens");
            new NQueensExample(i).solve();
        });
    }
}
