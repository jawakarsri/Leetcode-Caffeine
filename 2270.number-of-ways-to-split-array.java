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

