package dynamic_programming;

/**
 * A burglar comes to your colony at night. Your colony has many houses arranged
 * in linear fashion and each house has some amount of money. The burglar wishes to take as much money as possible.
 * But, he cannot rob 2 consecutive houses otherwise the security bell will ring and he will be caught.
 * The money in the houses are given in the form of an array named houses.
 * Find the maximum amt of money that he can rob.
 */
public class BurglarsNightOut {

    /**
     * Solution: either house no 0 can be robbed or not robbed (2 possibilities).
     * maxMoney[i] = max money that can be robbed from house no 'i' and houses
     * succeeding it.
     * @param houses: an array containing money stored in each house (house no indicated by index)
     * @return
     */
    public static int findMaxMoney(int houses[]) {
        int n = houses.length;
        if (n == 0)
            return 0;

        int maxMoney[] = new int[n+1];
        maxMoney[n] = 0;
        maxMoney[n-1] = houses[n-1];

        for (int i = n-2; i >= 0 ; i--) {
            maxMoney[i] = Math.max(houses[i] + maxMoney[i+2], maxMoney[i+1]);
        }

        return maxMoney[0];
    }

    public static void main(String[] args) {
        int houses[] = {3, 8, 10, 4, 1, 7}; //{2, 8, 4, 1};
        System.out.println("Max loot: " + findMaxMoney(houses));
    }
}
