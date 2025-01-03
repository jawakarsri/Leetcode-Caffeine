class Solution {
    public int minOperations(int[] nums, int k) {
        int minimum = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            minimum = Math.min(minimum, num);
        }
        if (minimum < k)
            return -1;
        if(minimum == k)
            return map.size() - 1;
        return map.size();//
    }
}