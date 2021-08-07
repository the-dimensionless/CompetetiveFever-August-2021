package algorithms.dynamic_programming;

import java.util.Arrays;

/**
 * Find the Longest forming subsequence : longest subsequence
 * such that all the elements are sorted in
 * increasing order
 */
public class LongestIncreasingSubSequence {
    /**
     * Solution: Let LIS[i] be longest increasing subsequence ending at ith element of array.
     *
     * @param args
     */

    public static void main(String[] args) {
        int arr[] = {11, 23, 10, 37, 21, 50, 80};
        int N = 7;

        int longestSubsequence[] = new int[N];
        int indexOfLastElement = 0;
        longestSubsequence[0] = -1;

        int max_length = 0;
        int LIS[] = new int[N];
        Arrays.fill(LIS, 1);

        for (int i = 1; i <= N-1; i++) {
            for (int j = 0; j <= i-1; j++) {
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                    longestSubsequence[i] = j;
                }
            }
            if (max_length < LIS[i]) {
                max_length = LIS[i];
                indexOfLastElement = i;
            }
        }
        while(indexOfLastElement != -1) {
            System.out.print(arr[indexOfLastElement] + " : ");
            indexOfLastElement = longestSubsequence[indexOfLastElement];
        }

//        for (int i = 0; i <= N-1 ; i++) {
//            if (max_length < LIS[i]) {
//                max_length = LIS[i];
//            }
//        }

        System.out.println("<- Longest Increasing Subsequence | length -> " + max_length );
    }
}
