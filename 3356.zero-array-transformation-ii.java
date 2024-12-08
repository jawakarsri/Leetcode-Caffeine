/*
 * @lc app=leetcode id=3356 lang=java
 *
 * [3356] Zero Array Transformation II
 */

// @lc code=start
class Solution {
    /**
     * This method checks if it is possible to transform the array `nums` to a zero array
     * using the first `k` queries.
     * 
     * @param nums the initial array
     * @param queries the list of queries where each query is of the form [start, end, value]
     * @param k the number of queries to consider
     * @return true if it is possible to transform the array to a zero array using the first `k` queries, false otherwise
     */
    public boolean isPossible(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int overlap[] = new int[n+1];

        // Apply the first `k` queries
        for (int i = 0; i < k; i++) {
            overlap[queries[i][0]] += queries[i][2];
            overlap[queries[i][1]+1] -= queries[i][2];
        }

        // Calculate the prefix sum and check if the transformation is possible
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += overlap[i];
            if (count < nums[i]) return false;
        }
        return true;
    }

    /**
     * This method finds the minimum number of queries required to transform the array `nums` to a zero array.
     * 
     * @param nums the initial array
     * @param queries the list of queries where each query is of the form [start, end, value]
     * @return the minimum number of queries required to transform the array to a zero array, or -1 if it is not possible
     */
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int low = 0, high = queries.length, res = -1;

        // Binary search to find the minimum number of queries
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, queries, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}

/**
 * Time Complexity:
 * - isPossible: O(n + k), where n is the length of the nums array and k is the number of queries considered.
 * - minZeroArray: O(n * log(m)), where n is the length of the nums array and m is the total number of queries.
 * 
 * Space Complexity:
 * - O(n) for the overlap array used in the isPossible method.
 * 
 * Approach:
 * - The isPossible method uses a prefix sum approach to efficiently apply the queries and check if the transformation is possible.
 * - The minZeroArray method uses binary search to find the minimum number of queries required to transform the array to a zero array.
 */
// @lc code=end

