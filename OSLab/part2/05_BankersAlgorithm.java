import java.util.*;

class BankersAlgorithm {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] al = new int[n][m];
        int[][] max = new int[n][m];
        int[][] need = new int[n][m];
        int[] av = new int[m];
        int[] work;
        int[] safe = new int[n];
        boolean[] done = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                al[i][j] = s.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max[i][j] = s.nextInt();
                need[i][j] = max[i][j] - al[i][j];
            }
        }
        for (int j = 0; j < m; j++) {
            av[j] = s.nextInt();
        }

        work = av.clone();
        int count = 0;
        while (count < n) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (!done[i]) {
                    boolean ok = true;
                    for (int j = 0; j < m; j++) {
                        if (need[i][j] > work[j]) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        for (int j = 0; j < m; j++) {
                            work[j] += al[i][j];
                        }
                        safe[count++] = i;
                        done[i] = true;
                        found = true;
                    }
                }
            }
            if (!found) {
                break;
            }
        }

        if (count < n) {
            System.out.println("System is not in a safe state.");
        } else {
            System.out.print("Safe sequence: ");
            for (int i = 0; i < n; i++) {
                System.out.print("P" + safe[i] + " ");
            }
        }
    }
}
