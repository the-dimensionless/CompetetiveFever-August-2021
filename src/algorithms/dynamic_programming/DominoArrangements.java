package algorithms.dynamic_programming;

/**
 * 2 X N grid and infinite dominoes of each size 1x2.
 * Fin the number of ways in which you can fill this grid
 * using these dominoes.
 * Note: Domino can only be placed in horizontal (1x2) mode
 * or vertical mode (2x1)
 */
public class DominoArrangements {
    /**
     * Solution: ways[i]  = no of ways to fill
     * = ways[i-1] + ways[i-2], i > 1
     * @param N
     * @return
     */
    public static int findWaysToFillGrid(int N) {
        int ways[] = new int[N+1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= N ; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[N];
    }
// without extra space
//    numberOfArrangements(n):
//            if n = 0 OR n = 1:
//            return 1
//    prev = 1 // This is for ways[0]
//    curr = 1  // This is for ways[1]
//            for i from 2 upto n:
//    temp = curr // This is just a temporary variable
//            curr = curr + prev
//    prev = temp
//     return curr

    public static void main(String[] args) {
        int N = 6;
        System.out.println("No of ways to tile: "+findWaysToFillGrid(N));

    }
}
