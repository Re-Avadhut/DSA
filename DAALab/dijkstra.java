package DAALab;

import java.util.Arrays;

public class dijkstra {

    static void dijkstra(int[][] g, int n, int src) {
        if (g == null || n < 0 || g.length != n || src < 0 || src >= n)
            throw new IllegalArgumentException("invalid graph or source");
        for (int[] row : g)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("graph must be square");
        int[] d = new int[n];
        boolean[] used = new boolean[n];

        Arrays.fill(d, Integer.MAX_VALUE);
        d[src] = 0;

        for (int c = 0; c < n; c++) {
            int u = -1;

            for (int i = 0; i < n; i++)
                if (!used[i] &&
                        (u == -1 || d[i] < d[u]))
                    u = i;

            if (u == -1 || d[u] == Integer.MAX_VALUE)
                break;

            used[u] = true;

            for (int v = 0; v < n; v++) {
                if (!used[v] && g[u][v] > 0 &&
                        d[u] <= Integer.MAX_VALUE - g[u][v] &&
                        d[u] + g[u][v] < d[v]) {
                    d[v] = d[u] + g[u][v];
                }
            }
        }

        for (int i = 0; i < n; i++)
            System.out.println(src + " -> " + i + " = " +
                    (d[i] == Integer.MAX_VALUE ? "INF" : d[i]));
    }

}
