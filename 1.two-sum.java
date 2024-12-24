/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the number and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[] { map.get(complement), i };
            }
            
            // Store the number and its index in the map
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (optional)
        return new int[] {};
    }
}
// @lc code=end

