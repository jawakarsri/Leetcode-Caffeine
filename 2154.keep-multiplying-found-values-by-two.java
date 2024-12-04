/*
 * @lc app=leetcode id=2154 lang=java
 *
 * [2154] Keep Multiplying Found Values by Two
 */

// @lc code=start
class Solution {
    public int findFinalValue(int[] nums, int original) {
        // Use a HashSet for fast lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        // Continue doubling the original value until it's not found in the set
        while (numSet.contains(original)) {
            original *= 2;
        }
        
        return original;
    }
}
class Solution {
    public int findFinalValue(int[] nums, int original) {
        int j=0;

            while(j<nums.length)
            {
                if(nums[j]==original)
                {
                    original=original*2;
                    j=0;
                }
                else
                j++;
            }   
            
            return (original);
    }
}
// @lc code=end

