import java.util.*;

public class MaxFlow {
    static int maxFlow(int[][] graph, int s, int t, int n) {
        if (graph == null || graph.length != n || n < 0
                || s < 0 || s >= n || t < 0 || t >= n || s == t)
            throw new IllegalArgumentException("invalid flow network");
        for (int[] row : graph)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("capacity matrix must be square");
        int[][] r = new int[n][n];
        for (int i = 0; i < n; i++)
            r[i] = graph[i].clone();

        int flow = 0;
        int[] parent = new int[n];

        while (true) {
            Arrays.fill(parent, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            parent[s] = s;

            while (!q.isEmpty() && parent[t] == -1) {
                int u = q.poll();
                for (int v = 0; v < n; v++) {
                    if (parent[v] == -1 && r[u][v] > 0) {
                        parent[v] = u;
                        q.add(v);
                    }
                }
            }

            if (parent[t] == -1)
                break;

            int path = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v])
                path = Math.min(path, r[parent[v]][v]);

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                r[u][v] -= path;
                r[v][u] += path;
            }

            if (path > Integer.MAX_VALUE - flow)
                throw new ArithmeticException("maximum flow overflow");
            flow += path;
        }
        return flow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        int s = sc.nextInt();
        int t = sc.nextInt();

        System.out.println(maxFlow(graph, s, t, n));
    }
}
