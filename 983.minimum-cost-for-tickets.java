/*
 * @lc app=leetcode id=983 lang=java
 *
 * [983] Minimum Cost For Tickets
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Time complexity: O(n + D)
        // Space complexity: O(D)
        // where n is the number of travel days and D is the last travel day
        
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] travelDays = new boolean[lastDay + 1];
        
        for (int day : days) {
            travelDays[day] = true;
        }
        
        for (int i = 1; i <= lastDay; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
        }
        
        return dp[lastDay];
    }
}
// @lc code=end

/*
Approach:
1. Use dynamic programming to keep track of the minimum cost up to each day.
2. Create an array `dp` where `dp[i]` represents the minimum cost to cover all travel days up to day `i`.
3. Create a boolean array `travelDays` to mark the days that are travel days.
4. Iterate through each day up to the last travel day:
   - If the day is not a travel day, the cost remains the same as the previous day.
   - Otherwise, calculate the minimum cost by considering the cost of 1-day, 7-day, and 30-day passes.
5. Return the minimum cost for the last travel day.
*/

