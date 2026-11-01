import java.util.*;

public class MemoryAllocation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of blocks: "); int n=sc.nextInt();
        int[] blocks=new int[n]; for(int i=0;i<n;i++) blocks[i]=sc.nextInt();
        System.out.print("Number of processes: "); int m=sc.nextInt();
        int[] proc=new int[m]; for(int i=0;i<m;i++) proc[i]=sc.nextInt();
        System.out.print("Strategy (1=First Fit, 2=Best Fit, 3=Worst Fit): "); int strategy=sc.nextInt();
        int[] rem=blocks.clone();
        for(int i=0;i<m;i++) {
            int idx=-1;
            for(int j=0;j<n;j++) {
                if(rem[j]>=proc[i] && (idx==-1 ||
                   (strategy==2 && rem[j]<rem[idx]) ||
                   (strategy==3 && rem[j]>rem[idx]))) idx=j;
                if(strategy==1 && idx!=-1) break;
            }
            if(idx==-1) System.out.println("Process " + (i+1) + " not allocated.");
            else { System.out.println("Process " + (i+1) + " -> Block " + (idx+1)); rem[idx]-=proc[i]; }
        }
    }
}
