class Solution {
    public int tupleSameProduct(int[] nums) {
Map <Integer,Integer> productcount = new HashMap<>();
int count =0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mul = nums[i] * nums[j];

                if (productcount.containsKey(mul)) {
count += productcount.get(mul);
                }
productcount.put(mul,productcount.getOrDefault(mul,0)+1);
            }
        }
return count*8;
    }
}