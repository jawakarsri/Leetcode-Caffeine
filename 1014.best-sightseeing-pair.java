/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */

// @lc code=start
class Solution {
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

