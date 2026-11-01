import java.util.*;

public class FCFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of processes: ");
        int n = sc.nextInt();
        int[] at = new int[n], bt = new int[n], ct = new int[n], tat = new int[n], wt = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Arrival and burst time for P" + (i + 1) + ": ");
            at[i] = sc.nextInt();
            bt[i] = sc.nextInt();
        }
        int time = 0;
        double totalWT = 0, totalTAT = 0;
        for (int i = 0; i < n; i++) {
            time = Math.max(time, at[i]);
            time += bt[i];
            ct[i] = time;
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            totalWT += wt[i];
            totalTAT += tat[i];
        }
        System.out.println("Process\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++)
            System.out.printf("P%d\t%d\t%d\t%d%n", i + 1, ct[i], tat[i], wt[i]);
        System.out.printf("Average TAT: %.2f%nAverage WT: %.2f%n", totalTAT / n, totalWT / n);
    }
}
