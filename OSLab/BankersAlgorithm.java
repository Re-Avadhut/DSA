import java.util.*;

public class BankersAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Processes and resource types: ");
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] alloc = new int[n][m], max = new int[n][m], need = new int[n][m];
        int[] avail = new int[m];
        System.out.println("Allocation matrix:");
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) alloc[i][j]=sc.nextInt();
        System.out.println("Maximum matrix:");
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) max[i][j]=sc.nextInt();
        System.out.println("Available resources:");
        for (int j=0;j<m;j++) avail[j]=sc.nextInt();
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) need[i][j]=max[i][j]-alloc[i][j];
        boolean[] finish = new boolean[n]; int[] work = avail.clone(), seq = new int[n]; int count=0;
        boolean progress;
        do {
            progress=false;
            for (int i=0;i<n;i++) if (!finish[i]) {
                boolean ok=true;
                for (int j=0;j<m;j++) if (need[i][j]>work[j]) ok=false;
                if (ok) {
                    for (int j=0;j<m;j++) work[j]+=alloc[i][j];
                    seq[count++]=i; finish[i]=true; progress=true;
                }
            }
        } while(progress);
        if(count==n) {
            System.out.print("Safe sequence: ");
            for(int i=0;i<n;i++) System.out.print("P"+seq[i]+(i<n-1?" -> ":"\n"));
        } else System.out.println("System is not in a safe state.");
    }
}
