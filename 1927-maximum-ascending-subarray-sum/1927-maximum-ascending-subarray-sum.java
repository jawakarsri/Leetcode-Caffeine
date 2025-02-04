class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0], curSum = nums[0], n = nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i]>nums[i-1])
                curSum+=nums[i];
            else
                curSum = nums[i];
            maxSum=Math.max(curSum,maxSum);
        }
        return maxSum;
    }
}