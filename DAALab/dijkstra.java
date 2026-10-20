package DAALab;

import java.util.*;

public class dijkstra {
    static final long INF = Long.MAX_VALUE / 4;

    static void dijkstra(int[][] graph, int src, int dest, int n) {
        if (graph == null || n < 0 || graph.length != n || src < 0 || src >= n
                || dest < 0 || dest >= n)
            throw new IllegalArgumentException("invalid graph or source/destination");
        for (int[] row : graph)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("graph must be square");

        for (int[] row : graph)
            for (int weight : row)
                if (weight < 0)
                    throw new IllegalArgumentException("Dijkstra requires non-negative edge weights");

        long[] dist = new long[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;
            long min = INF;

            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }
            }

            if (u == -1)
                break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0
                        && dist[u] <= INF - graph[u][v]
                        && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        if (dist[dest] == INF) {
            System.out.println("No path exists");
            return;
        }

        System.out.println("Shortest distance: " + dist[dest]);
        System.out.print("Shortest path: ");
        printPath(dest, parent);
        System.out.println();
    }

    static void printPath(int v, int[] parent) {
        if (v == -1)
            return;

        printPath(parent[v], parent);
        System.out.print(v + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();

        dijkstra(graph, src, dest, n);
        sc.close();
    }
}
