package DAALab;

import java.util.*;

public class kruskals {
    static int[] parent;

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] e = new int[m][3];

        for (int i = 0; i < m; i++) {
            e[i][0] = sc.nextInt();
            e[i][1] = sc.nextInt();
            e[i][2] = sc.nextInt();
        }

        Arrays.sort(e, (a, b) -> Integer.compare(a[2], b[2]));

        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int cost = 0, count = 0;

        for (int[] edge : e) {
            int u = edge[0], v = edge[1];

            if (find(u) != find(v)) {
                union(u, v);
                System.out.println(u + " -> " + v
                        + " : " + edge[2]);
                cost += edge[2];

                if (++count == n - 1)
                    break;
            }
        }

        System.out.println("MST Cost = " + cost);
        sc.close();
    }
}
