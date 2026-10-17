package DAALab;

import java.util.Arrays;

public class prims {

    static void prim(int[][] g, int n) {
        if (g == null || n <= 0 || g.length != n)
            throw new IllegalArgumentException("graph must be non-empty and square");
        for (int[] row : g)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("graph must be square");
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] used = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;
        int total = 0;

        for (int c = 0; c < n; c++) {
            int u = -1;

            for (int i = 0; i < n; i++)
                if (!used[i] &&
                        (u == -1 || key[i] < key[u]))
                    u = i;

            if (u == -1 || key[u] == Integer.MAX_VALUE) {
                System.out.println("MST not possible");
                return;
            }

            used[u] = true;
            if (key[u] > Integer.MAX_VALUE - total)
                throw new ArithmeticException("MST weight overflow");
            total += key[u];

            for (int v = 0; v < n; v++)
                if (!used[v] && g[u][v] > 0 &&
                        g[u][v] < key[v]) {
                    key[v] = g[u][v];
                    parent[v] = u;
                }
        }

        for (int i = 1; i < n; i++)
            System.out.println(parent[i] + " - " + i
                    + " : " + key[i]);

        System.out.println("MST weight = " + total);
    }

}
