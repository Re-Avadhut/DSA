package STS;

import java.util.Arrays;

public class MaxBiPartititeMatching {
    private static boolean bpm(boolean[][] graph, int u, boolean[] seen, int[] matchRight) {
        for (int v = 0; v < matchRight.length; v++) {
            if (graph[u][v] && !seen[v]) {
                seen[v] = true;
                if (matchRight[v] == -1 || bpm(graph, matchRight[v], seen, matchRight)) {
                    matchRight[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static int maxMatching(boolean[][] graph) {
        if (graph == null)
            throw new IllegalArgumentException("graph must not be null");
        int right = graph.length == 0 ? 0 : graph[0].length;
        for (boolean[] row : graph)
            if (row == null || row.length != right)
                throw new IllegalArgumentException("graph must be rectangular");

        int[] matchRight = new int[right];
        Arrays.fill(matchRight, -1);
        int result = 0;
        for (int u = 0; u < graph.length; u++)
            if (bpm(graph, u, new boolean[right], matchRight))
                result++;
        return result;
    }
}
