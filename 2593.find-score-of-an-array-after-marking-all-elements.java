/*
 * @lc app=leetcode id=2593 lang=java
 *
 * [2593] Find Score of an Array After Marking All Elements
 */

// @lc code=start
class Solution {
    /**
     * Approach:
     * 1. Create a 2D array to store the values and their original indices.
     * 2. Sort the 2D array based on the values.
     * 3. Use a boolean array to keep track of marked indices.
     * 4. Iterate through the sorted array, and for each unmarked index, add its value to the result and mark it and its neighbors.
     * 
     * Time Complexity: O(n log n) - due to sorting the array.
     * Space Complexity: O(n) - for the 2D array and the boolean array.
     */
    public long findScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        // Store values and their original indices
        for (int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        // Sort based on values
        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        boolean[] marked = new boolean[n];
        long result = 0;

        // Iterate through sorted array
        for (int[] arr : dp) {
            int val = arr[0];
            int ind = arr[1];

            // If index is not marked, add value to result and mark it and its neighbors
            if (!marked[ind]) {
                result += val;

                marked[ind] = true;
                if (ind > 0)
                    marked[ind - 1] = true;
                if (ind < n - 1) 
                    marked[ind + 1] = true;
            }
        }

        return result;
    }
}
// @lc code=end

