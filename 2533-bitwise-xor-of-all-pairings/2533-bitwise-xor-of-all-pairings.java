class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int xor = 0;
        if(n%2==1){
            for(int i=0;i<nums2.length;i++){
                xor ^= nums2[i];
            }
        }

        if(m%2==1){
            for(int i=0;i<nums1.length;i++){
                xor ^= nums1[i];
            }
        }

        return xor;
    }
}