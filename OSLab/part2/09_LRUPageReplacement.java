import java.util.*;

class LRUPageReplacement {
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

        List<Integer> mem = new ArrayList<>();
        int faults = 0;
        int hits = 0;
        for (int x : p) {
            if (mem.contains(x)) {
                hits++;
                mem.remove(Integer.valueOf(x));
                mem.add(x);
                System.out.println(x + " " + mem + " Hit");
            } else {
                faults++;
                if (mem.size() == f) {
                    mem.remove(0);
                }
                mem.add(x);
                System.out.println(x + " " + mem + " Fault");
            }
        }
        System.out.println("Page faults = " + faults);
        System.out.println("Page hits = " + hits);
    }
}
