package algorithms.dynamic_programming;

/**
 * Given an integer array, find sum of elements between indices i and j (i<=j) inclusive.
 */
public class SumOfRange {

    /**
     * sumRange(i,j) = Sum(jth element) - Sum(ith element)
     * Solution: sumUntil[i] = SumUntil[i-1] + array[i]
     * Note: sum is inclusive of ith and jth indices
     * @param arr
     * @param i
     * @param j
     * @return sum
     */
    public static int rangeQuerySum(int arr[], int i, int j) {
        if (i == 0)
            return arr[j];
        else
            return (arr[j] - arr[i - 1]);
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6};
        int N = 6;

        int sumUntil[] = new int[N];
        sumUntil[0] = 0;
        for (int i = 1; i < N; i++) {
            sumUntil[i] = sumUntil[i - 1] + arr[i];
        }

        System.out.println(String
                .format("Sum of range query i:%d j:%d is %d", 3, 5, rangeQuerySum(
                        sumUntil, 3, 5
                )));

    }
}
