package algorithms.dynamic_programming;

import java.util.Arrays;

/**
 * Reach Heaven at the top of staircase. It has N steps.
 * You can climb either 1 step or 2 steps at a time.
 * In how many ways can we reach the heaven ?
 */

public class StairwayToHeaven {
    /**
     * Solution: ways[i] = ways[i-1] + ways[i-2], i>1
     * which intuitively can be deduced to be fibonacci series!
     */
    public static int stairway2Heaven(int n) {
        int ways[] = new int[n + 1];
        Arrays.fill(ways, 0);
        // base cases
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 5, 6};
        Arrays.stream(arr).forEach((i) ->
                System.out.println(String
                        .format("For n = %d, ways = %d", i, stairway2Heaven(i))));

    }
}
