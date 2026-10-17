package DAALab;

import java.util.Arrays;

public class sorting {
    static void sort(int[] values) {
        if (values == null)
            throw new IllegalArgumentException("array must not be null");
        for (int i = 1; i < values.length; i++) {
            int key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] values = { 5, 2, 8, 1, 3 };
        sort(values);
        System.out.println(Arrays.toString(values));
    }
}
