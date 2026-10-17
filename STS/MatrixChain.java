package STS;

import java.util.*;

class MatrixChain {
    static int cost(int[] p) {
        if (p == null || p.length < 2)
            return 0;
        int n = p.length - 1;
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    long candidate = (long) dp[i][k] + dp[k + 1][j]
                            + (long) p[i] * p[k + 1] * p[j + 1];
                    if (candidate > Integer.MAX_VALUE)
                        throw new ArithmeticException("matrix-chain cost overflow");
                    dp[i][j] = Math.min(dp[i][j], (int) candidate);
                }
            }
        }
        return (dp[0][n - 1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        System.out.println(cost(p));
    }
}
