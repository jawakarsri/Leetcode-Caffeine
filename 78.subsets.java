/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Initialize the result list with the empty subset
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Start with the empty subset
        
        // Iterate over each number in the input array
        for (int num : nums) {
            int size = result.size();
            // For each existing subset, create a new subset that includes the current number
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }
        return result;
    }
}
// @lc code=end

/*
 * Approach:
 * - Start with an empty subset.
 * - For each number in the input array, add it to all existing subsets to create new subsets.
 * - Add these new subsets to the result list.
 *
 * Time Complexity: O(2^n)
 * - Each element can either be included or excluded from a subset, leading to 2^n subsets.
 * - For each subset, creating a new subset takes O(n) time in the worst case.
 *
 * Space Complexity: O(2^n)
 * - The space required to store all subsets is proportional to the number of subsets, which is 2^n.
 */

