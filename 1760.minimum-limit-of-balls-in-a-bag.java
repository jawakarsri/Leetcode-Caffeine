/*
 * @lc app=leetcode id=1760 lang=java
 *
 * [1760] Minimum Limit of Balls in a Bag
 */

// @lc code=start
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // Initialize the binary search range
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = right;

        // Perform binary search
        while (left <= right) {
            int mid = (left + right) / 2; // Calculate the midpoint
            int ops = 0; // Initialize the number of operations

            // Calculate the number of operations needed for the current midpoint
            for (int n : nums) {
                ops += (n - 1) / mid; // Calculate operations for each bag
                if (ops > maxOperations) { // If operations exceed the limit, break early
                    break;
                }
            }

            // Check if the current midpoint is a valid solution
            if (ops <= maxOperations) {
                ans = mid; // Update the answer
                right = mid - 1; // Narrow the search range to the left half
            } else {
                left = mid + 1; // Narrow the search range to the right half
            }
        }

        return ans; // Return the minimum possible maximum number of balls in any bag
    }
}

/*
 * Time Complexity: O(n log(max(nums)))
 * - The binary search runs in O(log(max(nums))) time, where max(nums) is the maximum number of balls in any bag.
 * - For each iteration of the binary search, we iterate through the nums array, which takes O(n) time.
 * - Therefore, the overall time complexity is O(n log(max(nums))).

 * Space Complexity: O(1)
 * - The algorithm uses a constant amount of extra space, regardless of the input size.
 * - The space complexity is O(1).
 */
// @lc code=end

