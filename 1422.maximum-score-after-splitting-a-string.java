/*
 * @lc app=leetcode id=1422 lang=java
 *
 * [1422] Maximum Score After Splitting a String
 */

// @lc code=start
class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            int score = countZeros(left) + countOnes(right);
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    private int countZeros(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count++;
        }
        return count;
    }

    private int countOnes(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') count++;
        }
        return count;
    }
}
// @lc code=end

/*
 * Approach:
 * Iterate through the string and split it at every possible position.
 * Calculate the score for each split by counting zeros in the left part and ones in the right part.
 * Keep track of the maximum score encountered.
 *
 * Time Complexity: O(n^2) - We iterate through the string and for each split, we count zeros and ones.
 * Space Complexity: O(1) - We use a constant amount of extra space.
 */

