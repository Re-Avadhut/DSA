package DAALab;

public class matrixchain {

    static int matrixChain(int[] p, int n) {
        if (p == null || n != p.length || n < 2)
            return 0;
        for (int dimension : p)
            if (dimension <= 0)
                throw new IllegalArgumentException("matrix dimensions must be positive");

        int[][] dp = new int[n][n];
        int[][] split = new int[n][n];

        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    long candidate = (long) dp[i][k] + dp[k + 1][j]
                            + (long) p[i - 1] * p[k] * p[j];
                    if (candidate > Integer.MAX_VALUE)
                        throw new ArithmeticException("matrix-chain cost overflow");
                    int cost = (int) candidate;

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Minimum cost: " + dp[1][n - 1]);
        System.out.print("Parenthesization: ");
        printParenthesis(split, 1, n - 1);
        System.out.println();

        return dp[1][n - 1];
    }

    static void printParenthesis(int[][] split, int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
            return;
        }

        System.out.print("(");
        printParenthesis(split, i, split[i][j]);
        System.out.print(" x ");
        printParenthesis(split, split[i][j] + 1, j);
        System.out.print(")");
    }

    public static void main(String[] args) {
        int[] p = { 10, 20, 30, 10 };
        matrixChain(p, p.length);
    }

}
