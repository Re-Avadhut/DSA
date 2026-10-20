package DAALab;

import java.util.*;

public class prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;

        for (int count = 0; count < n; count++) {
            int u = -1;

            for (int v = 0; v < n; v++) {
                if (!visited[v] &&
                        (u == -1 || key[v] < key[u])) {
                    u = v;
                }
            }

            if (u == -1 || key[u] == Integer.MAX_VALUE)
                break;

            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 &&
                        !visited[v] &&
                        graph[u][v] < key[v]) {

                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        int total = 0;
        int edges = 0;

        System.out.println("MST Edges:");

        for (int i = 1; i < n; i++) {
            if (parent[i] != -1) {
                System.out.println(
                        parent[i] + " -> " + i
                                + " : " + graph[parent[i]][i]);

                total += graph[parent[i]][i];
                edges++;
            }
        }

        if (edges == n - 1)
            System.out.println("Total MST Cost: " + total);
        else
            System.out.println("MST not possible: graph disconnected");

        sc.close();
    }
}
