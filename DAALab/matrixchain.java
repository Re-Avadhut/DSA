package DAALab;

public class matrixchain {

    static int matrixChain(int[] p, int n) {
        if (p == null || n != p.length || n < 2)
            return 0;
        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    long candidate = (long) dp[i][k] + dp[k + 1][j]
                            + (long) p[i - 1] * p[k] * p[j];
                    if (candidate > Integer.MAX_VALUE)
                        throw new ArithmeticException("matrix-chain cost overflow");
                    int cost = (int) candidate;

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n - 1];
    }

}
