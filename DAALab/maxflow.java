package DAALab;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class maxflow {

    static int maxFlow(int[][] capacity, int n, int s, int t) {
        if (capacity == null || capacity.length != n || n < 0
                || s < 0 || s >= n || t < 0 || t >= n || s == t)
            throw new IllegalArgumentException("invalid flow network");
        for (int[] row : capacity)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("capacity matrix must be square");
        int[][] residual = new int[n][n];

        for (int i = 0; i < n; i++)
            residual[i] = capacity[i].clone();

        int flow = 0;
        int[] parent = new int[n];

        while (true) {
            Arrays.fill(parent, -1);
            parent[s] = s;

            Queue<Integer> q = new LinkedList<>();
            q.offer(s);

            while (!q.isEmpty() && parent[t] == -1) {
                int u = q.poll();

                for (int v = 0; v < n; v++) {
                    if (parent[v] == -1 && residual[u][v] > 0) {
                        parent[v] = u;
                        q.offer(v);
                    }
                }
            }

            if (parent[t] == -1)
                break;

            int add = Integer.MAX_VALUE;

            for (int v = t; v != s; v = parent[v])
                add = Math.min(add, residual[parent[v]][v]);

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= add;
                residual[v][u] += add;
            }

            if (add > Integer.MAX_VALUE - flow)
                throw new ArithmeticException("maximum flow overflow");
            flow += add;
        }

        return flow;
    }

}
