import java.util.*;

class OptimalPageReplacement {
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
        for (int i = 0; i < n; i++) {
            int x = p[i];
            if (mem.contains(x)) {
                hits++;
                System.out.println(x + " " + mem + " Hit");
                continue;
            }

            faults++;
            if (mem.size() < f) {
                mem.add(x);
            } else {
                int victim = 0;
                int farthest = -1;
                for (int j = 0; j < mem.size(); j++) {
                    int next = Integer.MAX_VALUE;
                    for (int k = i + 1; k < n; k++) {
                        if (p[k] == mem.get(j)) {
                            next = k;
                            break;
                        }
                    }
                    if (next > farthest) {
                        farthest = next;
                        victim = j;
                    }
                }
                mem.set(victim, x);
            }
            System.out.println(x + " " + mem + " Fault");
        }
        System.out.println("Page faults = " + faults);
        System.out.println("Page hits = " + hits);
    }
}
