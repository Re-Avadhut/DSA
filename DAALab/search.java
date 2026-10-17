
package DAALab;

public class search {

    static int linearSearch(int[] a, int key) {
        if (a == null)
            throw new IllegalArgumentException("array must not be null");
        for (int i = 0; i < a.length; i++)
            if (a[i] == key)
                return i;
        return -1;
    }

    static int binarySearch(int[] a, int key) {
        if (a == null)
            throw new IllegalArgumentException("array must not be null");
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == key)
                return mid;
            if (a[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

}
