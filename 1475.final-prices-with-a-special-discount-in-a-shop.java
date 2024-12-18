/*
 * @lc app=leetcode id=1475 lang=java
 *
 * [1475] Final Prices With a Special Discount in a Shop
 */

// @lc code=start
class Solution {
    /**
     * This method calculates the final prices with a special discount.
     * 
     * Approach:
     * For each price in the array, find the first subsequent price that is less than or equal to it,
     * and subtract it from the current price.
     * 
     * Time Complexity: O(n^2) - For each price, we may need to check all subsequent prices.
     * Space Complexity: O(n) - We use an additional array to store the result.
     */
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prices[i];
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return result;
    }
}
// @lc code=end

