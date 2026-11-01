import java.util.*;

public class SegmentationSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of segments: "); int n = sc.nextInt();
        int[] base = new int[n], limit = new int[n];
        for (int i=0;i<n;i++) {
            System.out.print("Base and limit for segment " + i + ": ");
            base[i]=sc.nextInt(); limit[i]=sc.nextInt();
        }
        System.out.print("Segment number and offset: ");
        int s=sc.nextInt(), offset=sc.nextInt();
        if(s<0 || s>=n || offset<0 || offset>=limit[s]) System.out.println("Invalid address / segmentation fault.");
        else System.out.println("Physical address: " + (base[s]+offset));
    }
}
