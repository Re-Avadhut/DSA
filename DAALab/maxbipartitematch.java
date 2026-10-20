package DAALab;

import java.util.*;

class Main {
    static boolean bpm(boolean[][] g, int u,
            boolean[] seen, int[] matchR) {
        for (int v = 0; v < matchR.length; v++) {
            if (g[u][v] && !seen[v]) {
                seen[v] = true;

                if (matchR[v] == -1 ||
                        bpm(g, matchR[v], seen, matchR)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    static int maxMatching(boolean[][] g, int left, int right) {
        int[] matchR = new int[right];
        Arrays.fill(matchR, -1);

        int count = 0;

        for (int u = 0; u < left; u++) {
            boolean[] seen = new boolean[right];

            if (bpm(g, u, seen, matchR))
                count++;
        }

        System.out.println("Matched pairs:");
        for (int v = 0; v < right; v++) {
            if (matchR[v] != -1)
                System.out.println(matchR[v] + " - " + v);
        }

        System.out.println("Maximum matching = " + count);
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int left = sc.nextInt();
        int right = sc.nextInt();

        boolean[][] g = new boolean[left][right];

        // Input adjacency matrix
        for (int i = 0; i < left; i++)
            for (int j = 0; j < right; j++)
                g[i][j] = sc.nextInt() == 1;

        maxMatching(g, left, right);
        sc.close();
    }
}
