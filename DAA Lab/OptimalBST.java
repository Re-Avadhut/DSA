
import java.util.Arrays;

public class OptimalBST {

    static int optimalBST(int[] keys, int[] freq) {
        int n = keys.length;

        // dp[i][j] = minimum search cost for keys i to j
        int[][] dp = new int[n][n];

        // Prefix sum of frequencies
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + freq[i];
            dp[i][i] = freq[i];
        }

        // Length of the range
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                dp[i][j] = Integer.MAX_VALUE;

                // Sum of frequencies from i to j
                int sumFreq = prefix[j + 1] - prefix[i];

                // Try every key as root
                for (int r = i; r <= j; r++) {

                    int leftCost = (r > i) ? dp[i][r - 1] : 0;
                    int rightCost = (r < j) ? dp[r + 1][j] : 0;

                    int cost = leftCost + rightCost + sumFreq;

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] keys = { 10, 20, 30 };
        int[] freq = { 4, 2, 6 };

        System.out.println("Minimum search cost: "
                + optimalBST(keys, freq));
    }
}