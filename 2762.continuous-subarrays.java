/*
 * @lc app=leetcode id=2762 lang=java
 *
 * [2762] Continuous Subarrays
 */

// @lc code=start
class Solution {
    /**
     * This method calculates the number of continuous subarrays where the difference
     * between the maximum and minimum elements is at most 2.
     *
     * Approach:
     * - Use a sliding window technique with two pointers (left and right).
     * - Maintain a TreeMap to keep track of the frequency of elements in the current window.
     * - Expand the window by moving the right pointer and update the TreeMap.
     * - If the difference between the maximum and minimum elements in the window exceeds 2,
     *   shrink the window by moving the left pointer and update the TreeMap.
     * - Count the number of valid subarrays by adding the size of the current window.
     *
     * Time Complexity: O(n log n), where n is the length of the input array.
     * - Each element is inserted and removed from the TreeMap at most once, and each operation
     *   on the TreeMap takes O(log n) time.
     *
     * Space Complexity: O(n), where n is the length of the input array.
     * - The TreeMap can contain up to n elements in the worst case.
     */
    public long continuousSubarrays(int[] nums) {
        long count = 0;
        int n = nums.length;
        int left = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            // Shrink the window if the difference between max and min exceeds 2
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            // Count the number of valid subarrays ending at 'right'
            count += right - left + 1;
        }
        
        return count;
    }
}
// @lc code=end

