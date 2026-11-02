import java.util.*;

class Priority {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] bt = new int[n];
        int[] pr = new int[n];
        int[] p = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            bt[i] = s.nextInt();
            pr[i] = s.nextInt();
            p[i] = i + 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (pr[i] > pr[j]) {
                    int x = pr[i];
                    pr[i] = pr[j];
                    pr[j] = x;
                    x = bt[i];
                    bt[i] = bt[j];
                    bt[j] = x;
                    x = p[i];
                    p[i] = p[j];
                    p[j] = x;
                }
            }
        }

        double aw = 0;
        double at = 0;
        System.out.println("P\tBT\tPR\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                wt[i] = wt[i - 1] + bt[i - 1];
            }
            tat[i] = wt[i] + bt[i];
            aw += wt[i];
            at += tat[i];
            System.out.println("P" + p[i] + "\t" + bt[i] + "\t" + pr[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        System.out.printf("Average WT = %.2f%nAverage TAT = %.2f%n", aw / n, at / n);
    }
}
