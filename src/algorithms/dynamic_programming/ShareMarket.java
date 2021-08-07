package algorithms.dynamic_programming;

/**
 * Array in which ith element is price of stock on ith data.
 * At most 1 transaction (buy n sell once). Find max profit you can gain.
 * Rule: Cannot sell a stock before we buy one.
 */
public class ShareMarket {
    /**
     * Solution: Maximum profit = maximum selling price - minimum price till that day
     * MaxProfit[i] = max profit that we can make by selling the stock at day 'i'
     * MinUntil[i] = min stock price that we have seen until day 'i'
     * MaxProfit[i] = Price[i] - minUntil[i]
     */

    public static int maxProfit(Integer price[], int N) {
        Integer minUntil[] = new Integer[N];
        Integer maxProfit[] = new Integer[N];
        Integer highestProfit = Integer.MIN_VALUE;

        minUntil[0] = price[0];
        for (int i = 1; i < N - 1; i++) {
            minUntil[i] = Math.min(minUntil[i - 1], price[i]);
        }

        for (int i = 0; i < N - 1; i++) {
            maxProfit[i] = price[i] - minUntil[i];
            if (highestProfit < maxProfit[i]) {
                highestProfit = maxProfit[i];
            }
        }
        return highestProfit;
    }

    public static void main(String[] args) {
        int N = 6;
        Integer price[] = {8, 1, 2, 4, 6, 3};
        System.out.println("Maximum that can be earned is " + maxProfit(price, N));
    }
}
