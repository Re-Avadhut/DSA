package DAALab;

import java.util.Scanner;

public class obst {

    static class OBSTResult {
        int cost;
        int[][] root;

        OBSTResult(int cost, int[][] root) {
            this.cost = cost;
            this.root = root;
        }
    }

    static OBSTResult buildOBST(int[] freq) {
        int n = freq.length;
        int[][] dp = new int[n][n];
        int[][] root = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = freq[i];
            root[i][i] = i;
        }

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

                    if (candidate < dp[i][j]) {
                        dp[i][j] = (int) candidate;
                        root[i][j] = r;
                    }
                }
            }
        }

        int cost = n == 0 ? 0 : dp[0][n - 1];
        return new OBSTResult(cost, root);
    }

    static void printBST(int[] keys, int[][] root, int left, int right, String indent) {
        if (left > right)
            return;

        int rootIndex = root[left][right];
        System.out.println(indent + keys[rootIndex]);
        printBST(keys, root, left, rootIndex - 1, indent + "L-- ");
        printBST(keys, root, rootIndex + 1, right, indent + "R-- ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] keys = new int[n];
        int[] freq = new int[n];

        for (int i = 0; i < n; i++)
            keys[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            freq[i] = sc.nextInt();

        OBSTResult result = buildOBST(freq);

        System.out.println("Minimum cost: " + result.cost);
        System.out.println("Optimal BST:");
        if (n > 0) {
            printBST(keys, result.root, 0, n - 1, "");
        }
    }

}
