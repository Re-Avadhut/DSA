import java.util.*;

class TSP {

    static int[][] dist;
    static int[][] dp;
    static int[][] parent;
    static int n;

    static int tsp(int mask, int pos) {

        // All cities visited
        if (mask == (1 << n) - 1)
            return dist[pos][0];

        if (dp[mask][pos] != -1)
            return dp[mask][pos];

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {

            // If city is not visited
            if ((mask & (1 << city)) == 0) {

                int cost = dist[pos][city]
                        + tsp(mask | (1 << city), city);

                if (cost < ans) {
                    ans = cost;
                    parent[mask][pos] = city;
                }
            }
        }

        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {

        dist = new int[][] {
                { 0, 10, 15, 20 },
                { 10, 0, 35, 25 },
                { 15, 35, 0, 30 },
                { 20, 25, 30, 0 }
        };

        n = dist.length;

        dp = new int[1 << n][n];
        parent = new int[1 << n][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        for (int[] row : parent)
            Arrays.fill(row, -1);

        // Start from city 0
        int minCost = tsp(1, 0);

        System.out.println("Minimum cost = " + minCost);

        // Print path
        int mask = 1;
        int pos = 0;

        System.out.print("Path: 0 ");

        while (true) {

            int next = parent[mask][pos];

            if (next == -1)
                break;

            System.out.print("-> " + next);

            mask |= (1 << next);
            pos = next;
        }

        // Return to starting city
        System.out.println(" -> 0");
    }
}