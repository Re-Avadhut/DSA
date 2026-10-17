package DAALab;

public class obst {

    static int optimalBST(int[] freq, int n) {
        if (freq == null || n != freq.length || n < 0)
            throw new IllegalArgumentException("invalid frequency array");
        if (n == 0)
            return 0;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = freq[i];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int sum = 0;

                for (int k = i; k <= j; k++)
                    sum += freq[k];

                dp[i][j] = Integer.MAX_VALUE;

                for (int r = i; r <= j; r++) {
                    int left = (r > i) ? dp[i][r - 1] : 0;
                    int right = (r < j) ? dp[r + 1][j] : 0;

                    long candidate = (long) left + right + sum;
                    if (candidate > Integer.MAX_VALUE)
                        throw new ArithmeticException("optimal BST cost overflow");
                    dp[i][j] = Math.min(dp[i][j], (int) candidate);
                }
            }
        }

        return n == 0 ? 0 : dp[0][n - 1];
    }

}
