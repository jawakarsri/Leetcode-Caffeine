class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length<=1) return true;

        for(int i=0;i<nums.length;i++){
            if(nums[0]%2!=(nums[i]+i)%2) return false;
        }
        return true;
    }
}