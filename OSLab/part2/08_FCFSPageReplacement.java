import java.util.*;

class FCFSPageReplacement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Reference count: ");
        int n = s.nextInt();
        if (n < 0) {
            System.out.println("Reference count cannot be negative.");
            return;
        }
        int[] p = new int[n];
        System.out.println("Enter pages:");
        for (int i = 0; i < n; i++) {
            p[i] = s.nextInt();
        }

        System.out.print("Number of frames: ");
        int f = s.nextInt();
        if (f <= 0) {
            System.out.println("Invalid frames");
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        int faults = 0;
        int hits = 0;
        for (int x : p) {
            if (q.contains(x)) {
                hits++;
                System.out.println(x + " " + q + " Hit");
            } else {
                faults++;
                if (q.size() == f) {
                    q.poll();
                }
                q.add(x);
                System.out.println(x + " " + q + " Fault");
            }
        }
        System.out.println("Page faults = " + faults);
        System.out.println("Page hits = " + hits);
    }
}
