package DAALab;

import java.util.Arrays;

import java.util.*;

class tsp {
    static int n, all;
    static int[][] cost, dp, path;

    static int Tsp(int mask, int u) {
        if (mask == all)
            return cost[u][0];
        if (dp[mask][u] != -1)
            return dp[mask][u];

        dp[mask][u] = Integer.MAX_VALUE / 2;

        for (int v = 0; v < n; v++) {
            if ((mask & (1 << v)) == 0) {
                int c = cost[u][v] + tsp(mask | (1 << v), v);

                if (c < dp[mask][u]) {
                    dp[mask][u] = c;
                    path[mask][u] = v;
                }
            }
        }
        return dp[mask][u];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cost = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        all = (1 << n) - 1;
        dp = new int[1 << n][n];
        path = new int[1 << n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println("Minimum Cost = " + Tsp(1, 0));

        int mask = 1, u = 0;
        System.out.print("Path: 0");

        while (mask != all) {
            int v = path[mask][u];
            System.out.print(" -> " + v);
            mask |= (1 << v);
            u = v;
        }
        System.out.println(" -> 0");
    }
}
