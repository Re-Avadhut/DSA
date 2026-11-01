import java.util.*;

public class FIFO_PageReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of page references: "); int n=sc.nextInt();
        int[] pages=new int[n];
        for(int i=0;i<n;i++) pages[i]=sc.nextInt();
        System.out.print("Number of frames: "); int f=sc.nextInt();
        Queue<Integer> q=new LinkedList<>(); int faults=0;
        for(int p:pages) {
            if(!q.contains(p)) {
                faults++;
                if(q.size()==f) q.poll();
                if(f>0) q.offer(p);
            }
            System.out.println("Frames: " + q);
        }
        System.out.println("Page faults: " + faults);
    }
}
