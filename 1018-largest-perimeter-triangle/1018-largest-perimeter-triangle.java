class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        // Start from the largest possible triplet (last three elements)
        for (int i = nums.length - 1; i >= 2; i--) {
            int s1 = nums[i-2];
            int s2 = nums[i-1];
            int s3 = nums[i];
            if (s1 + s2 > s3) {  // Valid triangle condition
                return s1 + s2 + s3;  // Return the perimeter of the valid triangle
            }
        }
        return 0;  // No valid triangle exists
    }
}