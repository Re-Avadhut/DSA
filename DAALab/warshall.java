package DAALab;

import java.util.Arrays;

public class warshall {

    static void warshall(int[][] a, int n) {
        if (a == null || a.length != n || n < 0)
            throw new IllegalArgumentException("invalid adjacency matrix");
        for (int[] row : a)
            if (row == null || row.length != n)
                throw new IllegalArgumentException("adjacency matrix must be square");
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    a[i][j] = (a[i][j] != 0 ||
                            (a[i][k] != 0 && a[k][j] != 0))
                                    ? 1
                                    : 0;

        for (int[] row : a)
            System.out.println(Arrays.toString(row));
    }

}
