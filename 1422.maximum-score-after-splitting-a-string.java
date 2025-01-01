/*
 * @lc app=leetcode id=1422 lang=java
 *
 * [1422] Maximum Score After Splitting a String
 */

// @lc code=start
class Solution {
    public int maxScore(String inputStr) {
        int totalOnes = 0;
        int zerosCount = 0;
        int onesCount = 0;
        int bestScore = Integer.MIN_VALUE;

        // Count total ones in the string
        for (char ch : inputStr.toCharArray()) {
            if (ch == '1') totalOnes++;
        }

        // Traverse the string and calculate scores
        for (int i = 0; i < inputStr.length() - 1; i++) {
            if (inputStr.charAt(i) == '0') zerosCount++;
            else onesCount++;

            // Calculate score
            int currentScore = zerosCount + (totalOnes - onesCount);
            bestScore = Math.max(bestScore, currentScore);
        }

        return bestScore;
    }
}
// @lc code=end

/*
 * Approach:
 * Count the total number of ones in the string.
 * Traverse the string and keep track of the number of zeros and ones encountered so far.
 * For each position, calculate the score as the number of zeros on the left plus the number of ones on the right.
 * Keep track of the maximum score encountered.
 *
 * Time Complexity: O(n) - We iterate through the string twice.
 * Space Complexity: O(1) - We use a constant amount of extra space.
 */

