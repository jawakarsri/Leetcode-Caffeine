/*
 * @lc app=leetcode id=3264 lang=java
 *
 * [3264] Final Array State After K Multiplication Operations I
 */

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Arrays;

// @lc code=start
class Solution {
    /**
     * This method returns the final state of the array after performing k multiplication operations.
     * 
     * @param nums The input array of integers.
     * @param k The number of multiplication operations.
     * @param multiplier The multiplier to be used in each operation.
     * @return The final state of the array.
     * 
     * Time Complexity: O(k * n), where n is the length of the array.
     * Space Complexity: O(1), as we are modifying the input array in place.
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        for (int j = 0; j < k; j++) {
            // Find the index of the smallest element in the array
            int minIndex = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }

            // Multiply the smallest element by the multiplier
            nums[minIndex] *= multiplier;
        }

        return nums;
    }
}
// @lc code=end

