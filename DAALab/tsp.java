package DAALab;

import java.util.Arrays;

public class tsp {

    static int tsp(int[][] cost, int n) {
        if (cost == null || cost.length != n || n <= 0)
            throw new IllegalArgumentException("cost matrix must be non-empty and square");
        for (int[] row : cost)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("cost matrix must be square");
        if (n == 1)
            return 0;
        if (n > 20)
            throw new IllegalArgumentException("Too many cities");

        int INF = 1_000_000_000;
        int size = 1 << n;
        int[][] dp = new int[size][n];

        for (int[] row : dp)
            Arrays.fill(row, INF);
        dp[1][0] = 0;

        for (int mask = 1; mask < size; mask++) {
            if ((mask & 1) == 0)
                continue;

            for (int u = 0; u < n; u++) {
                if (dp[mask][u] == INF)
                    continue;

                for (int v = 1; v < n; v++) {
                    if ((mask & (1 << v)) == 0) {
                        int next = mask | (1 << v);
                        if (cost[u][v] < 0 || cost[u][v] >= INF)
                            continue;
                        long candidate = (long) dp[mask][u] + cost[u][v];
                        if (candidate < dp[next][v])
                            dp[next][v] = (int) candidate;
                    }
                }
            }
        }

        int ans = INF, full = size - 1;
        for (int u = 1; u < n; u++)
            if (cost[u][0] >= 0 && cost[u][0] < INF && dp[full][u] < INF)
                ans = Math.min(ans, (int) Math.min(INF, (long) dp[full][u] + cost[u][0]));

        return ans == INF ? -1 : ans;
    }

}
