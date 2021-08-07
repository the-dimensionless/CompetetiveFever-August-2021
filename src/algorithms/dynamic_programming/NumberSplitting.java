package algorithms.dynamic_programming;

import java.util.Arrays;

/**
 * N is a positive integer.
 * Split into integers of sum at least 2 integers such that
 * the multiplication forms the max product among all combinations possible.
 */
public class NumberSplitting {

    public static void main(String[] args) {
        int N = 5;
        System.out.println("Max sum formed is : " + findMaxProduct(N));
    }

    /**
     * Solution:numberSplitting(N):
     *     if N == 1:  return 0
     *     if N == 2:  return 1
     *     if N == 3:  return 2
     *     if N == 4:  return 4
     *     if N == 5:  return 6
     *     if N == 6:  return 9
     *     if N > 6:
     *         return 3*numberSplitting(N-3)
     *
     * @param n
     * @return
     */
    private static int findMaxProduct(int n) {
        int maxProduct[] = new int[n + 1];
        Arrays.fill(maxProduct, Integer.MIN_VALUE);

        maxProduct[1] = 0;
        maxProduct[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                maxProduct[i] = Math.max(
                        Math.max(
                                j * maxProduct[i - j], j * (i - j)
                        ),
                        maxProduct[i]
                );
            }
        }
        return maxProduct[n];
    }
}
