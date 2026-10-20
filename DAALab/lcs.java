package DAALab;

public class lcs {

    static int lcs(String s1, String s2) {
        if (s1 == null || s2 == null)
            throw new IllegalArgumentException("strings must not be null");
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Build DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]);
                }
            }
        }

        // Reconstruct LCS
        StringBuilder result = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; // Move up
            } else {
                j--; // Move left
            }
        }

        result.reverse();

        System.out.println("LCS Length: " + dp[m][n]);
        System.out.println("LCS: " + result);
        return dp[m][n];
    }

    public static void main(String[] args) {
        lcs("ABCBDAB", "BDCABA");
    }

}
