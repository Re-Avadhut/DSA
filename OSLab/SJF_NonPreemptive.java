import java.util.*;

public class SJF_NonPreemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of processes: ");
        int n = sc.nextInt();
        int[] at = new int[n], bt = new int[n], ct = new int[n], tat = new int[n], wt = new int[n];
        boolean[] done = new boolean[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Arrival and burst time for P" + (i + 1) + ": ");
            at[i] = sc.nextInt(); bt[i] = sc.nextInt();
        }
        int time = 0, completed = 0; double totalWT = 0, totalTAT = 0;
        while (completed < n) {
            int idx = -1;
            for (int i = 0; i < n; i++)
                if (!done[i] && at[i] <= time && (idx == -1 || bt[i] < bt[idx])) idx = i;
            if (idx == -1) { time++; continue; }
            time += bt[idx]; ct[idx] = time; tat[idx] = ct[idx] - at[idx]; wt[idx] = tat[idx] - bt[idx];
            done[idx] = true; completed++; totalWT += wt[idx]; totalTAT += tat[idx];
        }
        System.out.println("Process\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) System.out.printf("P%d\t%d\t%d\t%d%n", i + 1, ct[i], tat[i], wt[i]);
        System.out.printf("Average TAT: %.2f%nAverage WT: %.2f%n", totalTAT / n, totalWT / n);
    }
}
