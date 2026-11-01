import java.util.*;

public class Optimal_PageReplacement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of page references: "); int n=sc.nextInt();
        int[] pages=new int[n]; for(int i=0;i<n;i++) pages[i]=sc.nextInt();
        System.out.print("Number of frames: "); int f=sc.nextInt();
        List<Integer> frames=new ArrayList<>(); int faults=0;
        for(int i=0;i<n;i++) {
            int p=pages[i];
            if(!frames.contains(p)) {
                faults++;
                if(frames.size()==f && f>0) {
                    int victim=-1, farthest=-1;
                    for(int x:frames) {
                        int next=n;
                        for(int j=i+1;j<n;j++) if(pages[j]==x){next=j;break;}
                        if(next>farthest){farthest=next;victim=x;}
                    }
                    frames.remove(Integer.valueOf(victim));
                }
                if(f>0) frames.add(p);
            }
            System.out.println("Frames: " + frames);
        }
        System.out.println("Page faults: " + faults);
    }
}
