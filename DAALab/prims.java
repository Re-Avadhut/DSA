package DAALab;

import java.util.*;

import java.util.*;

class prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();

        int[] key = new int[n], parent = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(key, 99999);
        Arrays.fill(parent, -1);
        key[0] = 0;

        for (int k = 0; k < n; k++) {
            int u = -1;

            for (int i = 0; i < n; i++)
                if (!visited[i] && (u == -1 || key[i] < key[u]))
                    u = i;

            if (u == -1 || key[u] == 99999)
                break;
            visited[u] = true;

            for (int v = 0; v < n; v++)
                if (graph[u][v] > 0 && !visited[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
        }

        int total = 0;
        for (int v = 1; v < n; v++) {
            if (parent[v] != -1) {
                System.out.println(parent[v] + " - " + v + " : " + key[v]);
                total += key[v];
            }
        }
        System.out.println("MST Weight = " + total);
    }
}
