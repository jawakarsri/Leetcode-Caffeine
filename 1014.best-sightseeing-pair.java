/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */

// @lc code=start
class Solution {
    /**
     * Approach: Iterate through the array while maintaining the maximum value of
     * values[i] + i. For each j, calculate the score of the pair (i, j) and update
     * the maximum score.
     * 
     * Time Complexity: O(n) - where n is the length of the input array values.
     * Space Complexity: O(1) - only a few extra variables are used.
     */
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxI = values[0] + 0; // values[i] + i for the first element

        for (int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, maxI + values[j] - j); // calculate max score for pair (i, j)
            maxI = Math.max(maxI, values[j] + j); // update maxI for the next iteration
        }

        return maxScore;
    }
}
// @lc code=end

