package DAALab;

import java.util.Arrays;

public class warshallandfloyd {

    static void floydWarshall(int[][] d, int n) {
        final int INF = 1_000_000_000;

        if (d == null || d.length != n || n < 0)
            throw new IllegalArgumentException("invalid distance matrix");
        for (int[] row : d)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("distance matrix must be square");

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (d[i][k] != INF && d[k][j] != INF &&
                            (long) d[i][k] + d[k][j] < d[i][j]) {
                        long candidate = (long) d[i][k] + d[k][j];
                        if (candidate < Integer.MIN_VALUE || candidate > Integer.MAX_VALUE)
                            throw new ArithmeticException("distance overflow");
                        d[i][j] = (int) candidate;
                    }
                }

        for (int[] row : d) {
            for (int x : row)
                System.out.print((x == INF ? "INF" : x) + " ");
            System.out.println();
        }
    }

}
