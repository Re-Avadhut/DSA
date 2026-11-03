package DAALab;

import java.util.*;

class dijkstra {
    static final int INF = 99999;

    static void Dijkstra(int[][] graph, int src, int dest, int n) {
        int[] dist = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;
            int min = INF;

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
        int n = 5;
        int[][] graph = {
                { 0, 10, 0, 30, 100 },
                { 10, 0, 50, 0, 0 },
                { 0, 50, 0, 20, 10 },
                { 30, 0, 20, 0, 60 },
                { 100, 0, 10, 60, 0 }
        };

        int src = 0;
        int dest = 4;

        Dijkstra(graph, src, dest, n);
    }
}
