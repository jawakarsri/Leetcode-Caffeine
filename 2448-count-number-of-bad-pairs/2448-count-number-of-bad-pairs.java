class Solution {
    public long countBadPairs(int[] nums) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        long count = 0;

        for(int i=0;i<nums.length;i++){
            int diff = i-nums[i];
            count+=(hm.getOrDefault(diff,0));
            hm.put(diff,hm.getOrDefault(diff,0)+1);
        }

        return (((long)(nums.length)*(nums.length-1))/2)-count;

    }
}



