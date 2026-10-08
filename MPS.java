package STS;

//Maximum Product Subarray
//contiguous subarray with maximum product
//tc: O(n) sc: O(1)

public class MPS {
    static void findMaxProductSubarray(int[] arr, int n) {
        int maxSoFar = arr[0];
        int minSoFar = arr[0];
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            int x = arr[i];
            int tempMax = Math.max(x, Math.max(maxSoFar * x, minSoFar * x));
            int tempMin = Math.min(x, Math.min(maxSoFar * x, minSoFar * x));

            maxSoFar = tempMax;
            minSoFar = tempMin;

            result = Math.max(result, maxSoFar);
        }

        System.out.println("Maximum product subarray: " + result);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        int n = arr.length;
        findMaxProductSubarray(arr, n);
    }
}
