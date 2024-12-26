/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    /**
     * Approach: Use Depth-First Search (DFS) to explore all possible ways to assign
     * '+' and '-' to each element in the array.
     * 
     * Time Complexity: O(2^n) - where n is the length of the input array nums.
     * Space Complexity: O(n) - the depth of the recursion tree can go up to n.
     */
    public int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, 0, target);
    }

    private int calculate(int[] nums, int i, int sum, int target) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }
        return calculate(nums, i + 1, sum + nums[i], target) + calculate(nums, i + 1, sum - nums[i], target);
    }
}
// @lc code=end

