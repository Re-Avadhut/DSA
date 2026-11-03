package DAALab;

import java.util.*;

class maxbipartitematch {
    static boolean[][] g;
    static int[] match;
    static boolean[] vis;
    static int n, m;

    static boolean dfs(int u) {
        for (int v = 0; v < m; v++) {
            if (g[u][v] && !vis[v]) {
                vis[v] = true;

                if (match[v] == -1 || dfs(match[v])) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // Left vertices
        m = sc.nextInt(); // Right vertices

        g = new boolean[n][m];
        match = new int[m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                g[i][j] = sc.nextInt() == 1;

        Arrays.fill(match, -1);
        int count = 0;

        for (int u = 0; u < n; u++) {
            vis = new boolean[m];
            if (dfs(u))
                count++;
        }

        System.out.println("Maximum Matching = " + count);

        for (int v = 0; v < m; v++)
            if (match[v] != -1)
                System.out.println(match[v] + " - " + v);
    }
}
