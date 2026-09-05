import java.util.*;

public class TwoSumUsingHashSet {
    public static void main(String[] args) {
        int[] arr = { 4, 1, 6, 3, 8 };
        int target = 9;

        HashSet<Integer> seen = new HashSet<>();

        for (int x : arr) {
            int needed = target - x;

            if (seen.contains(needed)) {
                System.out.println(x + " + " + needed);
                break;
            }

            seen.add(x);
        }
    }
}
