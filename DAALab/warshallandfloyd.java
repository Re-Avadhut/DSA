package DAALab;

import java.util.*;

public class warshallandfloyd {
    static final int INF = 1_000_000_000;

    static void floydWarshall(int[][] dist, int n) {
        if (dist == null || n < 0 || dist.length != n)
            throw new IllegalArgumentException("invalid distance matrix");
        for (int[] row : dist)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("distance matrix must be square");

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long candidate = (long) dist[i][k] + dist[k][j];
                    if (dist[i][k] != INF && dist[k][j] != INF
                            && candidate < dist[i][j]) {
                        if (candidate < Integer.MIN_VALUE || candidate > Integer.MAX_VALUE)
                            throw new ArithmeticException("distance overflow");
                        dist[i][j] = (int) candidate;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                dist[i][j] = (x == -1) ? INF : x;
            }
        }

        floydWarshall(dist, n);
    }
}
