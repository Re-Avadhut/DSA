package STS;

// Sliding Window Technique : longest subarray with at most k zeros
// tc: O(n) sc: O(1)

class SlidingWindow {
    static int longestOnes(int[] nums, int k) {
        int left = 0;
        int max = 0;
        int zeros = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 0, 1, 1, 1, 0, 1 };
        int k = 2;
        System.out.println(longestOnes(nums, k));
    }
}