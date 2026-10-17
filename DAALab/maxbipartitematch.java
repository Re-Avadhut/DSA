package DAALab;

import java.util.Arrays;

public class maxbipartitematch {

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
        if (g == null || left < 0 || right < 0 || g.length != left)
            throw new IllegalArgumentException("invalid bipartite graph dimensions");
        for (boolean[] row : g)
            if (row == null || row.length != right)
                throw new IllegalArgumentException("invalid bipartite graph dimensions");
        int[] matchR = new int[right];
        Arrays.fill(matchR, -1);

        int result = 0;

        for (int u = 0; u < left; u++) {
            boolean[] seen = new boolean[right];

            if (bpm(g, u, seen, matchR))
                result++;
        }

        return result;
    }

}
