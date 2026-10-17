package STS;

import java.util.*;

public class MaxMatching {
    static boolean bpm(int u, int[][] g, boolean[] seen,
            int[] match, int m) {
        for (int v = 0; v < m; v++) {
            if (g[u][v] == 1 && !seen[v]) {
                seen[v] = true;

                if (match[v] == -1 ||
                        bpm(match[v], g, seen, match, m)) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] g = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                g[i][j] = sc.nextInt();

        int[] match = new int[m];
        Arrays.fill(match, -1);

        int count = 0;
        for (int u = 0; u < n; u++) {
            if (bpm(u, g, new boolean[m], match, m))
                count++;
        }

        System.out.println(count);
        for (int v = 0; v < m; v++)
            if (match[v] != -1)
                System.out.println(match[v] + " " + v);
    }
}
