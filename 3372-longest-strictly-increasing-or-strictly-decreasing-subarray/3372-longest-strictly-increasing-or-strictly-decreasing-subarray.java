class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int cnt1=1;
        int cnt2=1;
        int maxLen=1;
        
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]) cnt1+=1;
            else cnt1=1;
            if(nums[i]>nums[i+1]) cnt2++;
            else cnt2=1;
            maxLen=Math.max(maxLen,cnt1);
            maxLen=Math.max(maxLen,cnt2);
        }

        return maxLen;
    }
}