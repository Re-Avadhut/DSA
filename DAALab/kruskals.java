package DAALab;

import java.util.Arrays;

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

    static int find(int[] p, int x) {
        if (p[x] != x)
            p[x] = find(p, p[x]);
        return p[x];
    }

    static boolean union(int[] p, int[] rank, int a, int b) {
        a = find(p, a);
        b = find(p, b);

        if (a == b)
            return false;

        if (rank[a] < rank[b])
            p[a] = b;
        else if (rank[a] > rank[b])
            p[b] = a;
        else {
            p[b] = a;
            rank[a]++;
        }
        return true;
    }

    static void kruskal(int n, Edge[] edges) {
        if (n < 0 || edges == null)
            throw new IllegalArgumentException("invalid graph");
        Arrays.sort(edges);

        int[] p = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = i;

        int total = 0, count = 0;

        for (Edge e : edges) {
            if (union(p, rank, e.u, e.v)) {
                System.out.println(e.u + " - " + e.v
                        + " : " + e.w);
                if ((e.w > 0 && total > Integer.MAX_VALUE - e.w)
                        || (e.w < 0 && total < Integer.MIN_VALUE - e.w))
                    throw new ArithmeticException("MST weight overflow");
                total += e.w;
                count++;
                if (count == n - 1)
                    break;
            }
        }

        if (count != n - 1)
            System.out.println("MST not possible");
        else
            System.out.println("MST weight = " + total);
    }

}
