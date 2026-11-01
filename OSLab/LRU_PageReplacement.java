import java.util.*;

public class LRU_PageReplacement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of page references: "); int n=sc.nextInt();
        int[] pages=new int[n]; for(int i=0;i<n;i++) pages[i]=sc.nextInt();
        System.out.print("Number of frames: "); int f=sc.nextInt();
        LinkedHashSet<Integer> frames=new LinkedHashSet<>(); int faults=0;
        for(int p:pages) {
            if(!frames.contains(p)) {
                faults++;
                if(frames.size()==f && f>0) frames.remove(frames.iterator().next());
                if(f>0) frames.add(p);
            } else { frames.remove(p); frames.add(p); }
            System.out.println("Frames (LRU to MRU): " + frames);
        }
        System.out.println("Page faults: " + faults);
    }
}
