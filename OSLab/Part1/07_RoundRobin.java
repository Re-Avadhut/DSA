import java.util.*;

class RoundRobin {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] bt = new int[n];
        int[] rem = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];

        for (int i = 0; i < n; i++) {
            bt[i] = s.nextInt();
            rem[i] = bt[i];
        }
        int q = s.nextInt();
        int time = 0;
        int done;
        do {
            done = 0;
            for (int i = 0; i < n; i++) {
                if (rem[i] > 0) {
                    int x = Math.min(q, rem[i]);
                    time += x;
                    rem[i] -= x;
                    if (rem[i] == 0) {
                        tat[i] = time;
                    }
                } else {
                    done++;
                }
            }
        } while (done < n);

        double aw = 0;
        double at = 0;
        System.out.println("P\tBT\tWT\tTAT");
        for (int i = 0; i < n; i++) {
            wt[i] = tat[i] - bt[i];
            aw += wt[i];
            at += tat[i];
            System.out.println("P" + (i + 1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        System.out.printf("Average WT = %.2f%nAverage TAT = %.2f%n", aw / n, at / n);
    }
}
