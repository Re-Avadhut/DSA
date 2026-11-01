package DAALab;

import java.util.*;

class Main {
    static int maxFlow(int[][] capacity, int n, int s, int t) {
        int[][] residual = new int[n][n];

        for (int i = 0; i < n; i++)
            residual[i] = capacity[i].clone();

        int flow = 0;
        int[] parent = new int[n];

        if (s == t)
            return 0;

        while (true) {
            Arrays.fill(parent, -1);
            parent[s] = s;

            Queue<Integer> q = new LinkedList<>();
            q.offer(s);

            // BFS to find an augmenting path
            while (!q.isEmpty() && parent[t] == -1) {
                int u = q.poll();

                for (int v = 0; v < n; v++) {
                    if (parent[v] == -1 && residual[u][v] > 0) {
                        parent[v] = u;
                        q.offer(v);
                    }
                }
            }

            // No more augmenting paths
            if (parent[t] == -1)
                break;

            // Find bottleneck capacity
            int add = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v])
                add = Math.min(add, residual[parent[v]][v]);

            // Print augmenting path
            List<Integer> path = new ArrayList<>();
            for (int v = t; v != s; v = parent[v])
                path.add(v);
            path.add(s);
            Collections.reverse(path);

            System.out.println("Path: " + path);
            System.out.println("Flow added: " + add);

            // Update residual capacities
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= add;
                residual[v][u] += add;
            }

            flow += add;
            System.out.println();
        }

        System.out.println("Maximum Flow = " + flow);
        return flow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] capacity = new int[n][n];

        // Input capacity matrix
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                capacity[i][j] = sc.nextInt();

        int s = sc.nextInt();
        int t = sc.nextInt();

        maxFlow(capacity, n, s, t);
        sc.close();
    }
}
