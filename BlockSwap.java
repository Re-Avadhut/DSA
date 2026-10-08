package STS;

//Block Swap Algorithm
//left rotate an array by d elements
//tc: O(n) sc: O(1)
public class BlockSwap {
    public static void swap(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void leftRotate(int[] arr, int d, int n) {
        d = d % n;
        if (d == 0)
            return;

        swap(arr, 0, d - 1);
        swap(arr, d, n - 1);
        swap(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int d = 2;
        int n = arr.length;
        leftRotate(arr, d, n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
