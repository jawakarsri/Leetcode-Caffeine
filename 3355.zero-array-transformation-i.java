/**
 * @lc app=leetcode id=3355 lang=java
 *
 * [3355] Zero Array Transformation I
 */

// @lc code=start
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;

        // Sort the queries based on the starting index, and then by the ending index
        Arrays.sort(queries, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int l = 0, r = 0, len = queries.length;
        // Priority queue to keep track of the queries, sorted by the ending index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Iterate through each element in the nums array
        for (int i = 0; i < n; i++) {
            // Add all queries that include the current index i
            while (r < len && queries[r][0] <= i && i <= queries[r][1]) {
                pq.add(queries[r++]);
            }

            // Remove queries that have ended before the current index i
            while (!pq.isEmpty() && pq.peek()[1] < i) pq.remove();

            // If the number of valid queries is less than the value at nums[i], return false
            if (pq.size() < nums[i]) return false;
        }

        // If all elements in nums can be covered by the queries, return true
        return true;
    }
}
// @lc code=end
/**Time Complexity
The time complexity of this solution is O(n log m), where n is the length of the nums array and m is the number of queries. This is because we sort the queries, which takes O(m log m), and then for each element in nums, we may add and remove elements from the priority queue, which takes O(log m) time per operation.

Space Complexity
The space complexity of this solution is O(m), where m is the number of queries. This is because we store the queries in a priority queue, which can hold up to m elements in the worst case.

