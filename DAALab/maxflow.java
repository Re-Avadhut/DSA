package DAALab;

import java.util.*;

class maxflow {
    static int n;
    static int[][] cap;
    static boolean[] vis;
    static int[] parent;

    static boolean bfs(int s, int t) {
        Arrays.fill(vis, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v = 0; v < n; v++) {
                if (!vis[v] && cap[u][v] > 0) {
                    parent[v] = u;
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return vis[t];
    }

    static int maxFlow(int s, int t) {
        int flow = 0;

        while (bfs(s, t)) {
            int add = Integer.MAX_VALUE;

            for (int v = t; v != s; v = parent[v])
                add = Math.min(add, cap[parent[v]][v]);

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                cap[u][v] -= add;
                cap[v][u] += add;
            }

            flow += add;
        }
        return flow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        cap = new int[n][n];
        vis = new boolean[n];
        parent = new int[n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cap[i][j] = sc.nextInt();

        System.out.println("Max Flow = " + maxFlow(0, n - 1));
    }
}
