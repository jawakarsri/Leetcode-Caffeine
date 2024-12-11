/*
 * @lc app=leetcode id=2779 lang=java
 *
 * [2779] Maximum Beauty of an Array After Applying Operation
 */

// @lc code=start
class Solution {
    /**
     * This method calculates the maximum beauty of an array after applying the operation.
     * 
     * @param nums the input array of integers
     * @param k the integer value used in the operation
     * @return the maximum beauty of the array
     */
    public int maximumBeauty(int[] nums, int k) {
        // If the array has only one element, its beauty is 1
        if (nums.length == 1)
            return 1;

        int maxBeauty = 0;
        int maxValue = 0;

        // Find the maximum value in the array
        for (int num : nums)
            maxValue = Math.max(maxValue, num);

        // Create a count array to keep track of the range modifications
        int[] count = new int[maxValue + 1];

        // Apply the range modifications based on the value of k
        for (int num : nums) {
            count[Math.max(num - k, 0)]++;
            count[Math.min(num + k + 1, maxValue)]--;
        }

        int currentSum = 0;

        // Calculate the maximum beauty by finding the maximum prefix sum
        for (int val : count) {
            currentSum += val;
            maxBeauty = Math.max(maxBeauty, currentSum);
        }

        return maxBeauty;
    }
}

/*
 * Time Complexity: O(n + m), where n is the length of the input array nums and m is the maximum value in nums.
 * Space Complexity: O(m), where m is the maximum value in nums.
 */
// @lc code=end

