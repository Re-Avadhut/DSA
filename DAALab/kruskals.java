package DAALab;

import java.util.*;

public class kruskals {

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e) {
            return Integer.compare(this.w, e.w);
        }
    }

    static int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);

        return parent[x];
    }

    static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX == rootY)
            return;

        if (rank[rootX] < rank[rootY])
            parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY])
            parent[rootY] = rootX;
        else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        Arrays.sort(edges);

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        int total = 0;
        int count = 0;

        System.out.println("MST Edges:");

        for (Edge e : edges) {
            int x = find(parent, e.u);
            int y = find(parent, e.v);

            if (x != y) {
                System.out.println(
                        e.u + " -> " + e.v + " : " + e.w);

                union(parent, rank, x, y);

                total += e.w;
                count++;

                if (count == n - 1)
                    break;
            }
        }

        if (count == n - 1)
            System.out.println("Total MST Cost: " + total);
        else
            System.out.println("MST not possible: graph disconnected");

        sc.close();
    }
}
