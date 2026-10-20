package DAALab;

public class sorting {

    static void sort(int[] a) {
        insertionSort(a);
    }

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++)
            for (int j = 0; j < a.length - 1 - i; j++)
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
    }

    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (a[j] < a[min])
                    min = j;

            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    static void mergeSort(int[] a, int l, int r) {
        if (l >= r)
            return;

        int m = l + (r - l) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);

        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r)
            temp[k++] = a[i] <= a[j] ? a[i++] : a[j++];

        while (i <= m)
            temp[k++] = a[i++];
        while (j <= r)
            temp[k++] = a[j++];

        for (i = 0; i < temp.length; i++)
            a[l + i] = temp[i];
    }

    static void quickSort(int[] a, int low, int high) {
        if (low >= high)
            return;

        int pivot = a[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        int t = a[i + 1];
        a[i + 1] = a[high];
        a[high] = t;

        int p = i + 1;
        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }

}
