
package DAALab;

import java.util.*;

public class arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("Array size must be positive");
            sc.close();
            return;
        }
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        // Reverse array
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        // Maximum element
        int max = a[0];
        for (int x : a)
            if (x > max)
                max = x;

        System.out.println(Arrays.toString(a));
        System.out.println("Max = " + max);
        sc.close();
    }
}
