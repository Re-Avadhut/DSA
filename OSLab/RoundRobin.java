import java.util.*;

public class RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of processes: ");
        int n = sc.nextInt();
        int[] bt = new int[n], rem = new int[n], wt = new int[n], tat = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Burst time for P" + (i + 1) + ": ");
            bt[i] = rem[i] = sc.nextInt();
        }
        System.out.print("Time quantum: ");
        int q = sc.nextInt(), time = 0, completed;
        do {
            completed = 0;
            for (int i = 0; i < n; i++) {
                if (rem[i] > 0) {
                    int run = Math.min(q, rem[i]); time += run; rem[i] -= run;
                    if (rem[i] == 0) { tat[i] = time; wt[i] = tat[i] - bt[i]; }
                } else completed++;
            }
        } while (completed < n);
        System.out.println("Process\tBT\tTAT\tWT");
        double tw = 0, tt = 0;
        for (int i = 0; i < n; i++) {
            System.out.printf("P%d\t%d\t%d\t%d%n", i + 1, bt[i], tat[i], wt[i]);
            tw += wt[i]; tt += tat[i];
        }
        System.out.printf("Average TAT: %.2f%nAverage WT: %.2f%n", tt / n, tw / n);
    }
}
