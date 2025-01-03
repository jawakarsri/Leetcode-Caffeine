/*
 * @lc app=leetcode id=2270 lang=java
 *
 * [2270] Number of Ways to Split Array
 */

// @lc code=start
class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        long leftSum = 0;
        int ways = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            if (leftSum >= totalSum - leftSum) {
                ways++;
            }
        }
        
        return ways;
    }
}
// @lc code=end

/*
 * Approach:
 * 1. Calculate the total sum of the array.
 * 2. Iterate through the array, maintaining a running sum for the left part.
 * 3. For each position, check if the left sum is greater than or equal to the right sum.
 * 4. Count the number of valid splits.
 *
 * Time Complexity: O(n) - We iterate through the array twice.
 * Space Complexity: O(1) - We use a constant amount of extra space.
 */

