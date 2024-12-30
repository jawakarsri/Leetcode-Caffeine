/*
 * @lc app=leetcode id=2466 lang=java
 *
 * [2466] Count Ways To Build Good Strings
 */

// @lc code=start
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
        }
        
        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % mod;
        }
        
        return result;
    }
}
// @lc code=end

/*
 * Approach:
 * - Use dynamic programming to count the number of good strings.
 * - dp[i] represents the number of ways to build a string of length i.
 * - Initialize dp[0] to 1 because there is one way to build an empty string.
 * - For each length from 1 to high, update dp[i] by adding the number of ways to build strings of length (i - zero) and (i - one).
 * - Sum up the number of ways to build strings from length low to high.
 *
 * Time Complexity: O(n) where n is the value of 'high'.
 * Space Complexity: O(n) where n is the value of 'high'.
 */

