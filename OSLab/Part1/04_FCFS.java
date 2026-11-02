import java.util.*;

class FCFS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Number of processes: ");
        int n = s.nextInt();
        int[] bt = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            bt[i] = s.nextInt();
        }
        for (int i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        double aw = 0;
        double at = 0;
        System.out.println("P\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            tat[i] = wt[i] + bt[i];
            aw += wt[i];
            at += tat[i];
            System.out.println("P" + (i + 1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        System.out.printf("Average WT = %.2f%nAverage TAT = %.2f%n", aw / n, at / n);
    }
}
