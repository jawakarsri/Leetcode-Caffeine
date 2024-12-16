/*
 * @lc app=leetcode id=1200 lang=java
 *
 * [1200] Minimum Absolute Difference
 */

import java.util.*;

// @lc code=start
class Solution {
    /**
     * Finds all pairs of elements with the minimum absolute difference in a sorted array.
     * 
     * Approach:
     * 1. Sort the array.
     * 2. Iterate through the sorted array to find the minimum absolute difference.
     * 3. Collect all pairs with the minimum absolute difference.
     * 
     * Time Complexity: O(n log n) due to sorting, where n is the length of the array.
     * Space Complexity: O(n) for storing the result.
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr); // Sort the array
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        // Find the minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                result.clear(); // Clear the result list if a new minimum difference is found
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i])); // Add the pair to the result list
            }
        }
        return result;
    }
}
// @lc code=end

