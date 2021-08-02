package dynamic_programming;

/**
 * Same as prev. find lowest fee in order to reach heaven.
 * steps -> 1, 2 or 3.
 */
public class Stairway2Heaven2 {

    /**
     * Solution: min[i] = min ( fee[i-1] + min[i-1] , fee[i-2] + min[i-2] , fee[i-3] + min[i-3]
     *
     * @param fee
     * @param n
     * @return
     */

    public static int cost(int fee[], int n) {
        int minFee[] = new int[n + 1];
        minFee[0] = 0;
        minFee[1] = minFee[2] = fee[0];
        for (int i = 3; i <= n; i++) {
            minFee[i] = Math.min(minFee[i - 1] + fee[i - 1],
                    Math.min(minFee[i - 2] + fee[i - 2], minFee[i - 3] + fee[i - 3]));
        }
        return minFee[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int fee[] = {2, 1, 3, 1, 2};

        System.out.println("cost: " + cost(fee, n));
    }
}
