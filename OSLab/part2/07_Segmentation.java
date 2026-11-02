import java.util.*;

class Segmentation {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] base = new int[n];
        int[] limit = new int[n];
        for (int i = 0; i < n; i++) {
            base[i] = s.nextInt();
            limit[i] = s.nextInt();
        }

        int p = s.nextInt();
        System.out.println("Segment\tBase\tLimit");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t" + base[i] + "\t" + limit[i]);
        }
        for (int i = 0; i < p; i++) {
            int off = s.nextInt();
            int seg = s.nextInt();
            if (seg < 0 || seg >= n || off < 0 || off >= limit[seg]) {
                System.out.println("Invalid address");
            } else {
                System.out.println("Physical address = " + (base[seg] + off));
            }
        }
    }
}
