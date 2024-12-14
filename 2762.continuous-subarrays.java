/*
 * @lc app=leetcode id=2762 lang=java
 *
 * [2762] Continuous Subarrays
 */

// @lc code=start
class Solution {
    public long continuousSubarrays(int[] nums) {
        long count = 0;
        int n = nums.length;
        int left = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            count += right - left + 1;
        }
        
        return count;
    }
}
// @lc code=end

