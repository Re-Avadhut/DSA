package STS;

//Maximum Equilibrium Index
//index where sum of left and right elements are equal
//tc: O(n^2) sc: O(1)
//for optimized solution tc: O(n) sc: O(1)

public class MaxEquiSum {
    static int maxEquiSum(int[] arr) {
        int n = arr.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            int rightSum = 0;
            for (int j = i + 1; j < n; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                res = Math.max(res, i);
            }
        }

        return res == Integer.MIN_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        int index = maxEquiSum(arr);
        if (index != -1) {
            System.out.println("Equilibrium index: " + index);
        } else {
            System.out.println("No equilibrium index found.");
        }
    }

    static int maxEquilibriumSum(int[] arr) {
        int total = 0;

        for (int x : arr)
            total += x;

        int leftSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int x : arr) {
            int rightSum = total - leftSum - x;

            if (leftSum == rightSum)
                maxSum = Math.max(maxSum, leftSum);

            leftSum += x;
        }

        return maxSum;
    }
}
