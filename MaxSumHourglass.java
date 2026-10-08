package STS;
//Maximum Sum Hourglass

//tc: O(n x m) sc: O(1)

public class MaxSumHourglass {
    static int maxSumHourglass(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int row = arr.length;
        int col = arr[0].length;
        if (row < 3 || col < 3) {
            return -1; // Not enough elements for an hourglass
        }
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0 },
                { 0, 0, 2, 4, 4, 0 },
                { 0, 0, 0, 2, 0, 0 },
                { 0, 0, 1, 2, 4, 0 }
        };
        System.out.println(maxSumHourglass(arr));
    }
}
