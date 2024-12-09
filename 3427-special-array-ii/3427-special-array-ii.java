class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int bit = nums[0] % 2;
        int n = nums.length, m = queries.length;
        Map<Integer, Integer> hm = new HashMap<>();
        int curr = 0;
        for(int i=1; i<n; i++){
            if(bit == nums[i] % 2){
                hm.put(curr, i-1);
                curr = i;
            }else{
                bit ^= 1;
            }
        }
        hm.put(curr, n-1);
        boolean res[] = new boolean[m];
        List<Integer> list = hm.keySet().stream().collect(Collectors.toList());
        Collections.sort(list);
        for(int i=0; i<m; i++){
            if(nums.length == 1){
                res[i] = true;
                continue;
            }
            res[i] = bs(queries[i], list, hm);
        }
        return res;
    }
    private boolean bs(int q[], List<Integer> list, Map<Integer, Integer> hm){
        if(q[0] == q[1] ) return true;
        int l = 0, r = list.size() - 1;
        int res = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(list.get(mid) > q[0]){
                r = mid - 1;
            }else{
                res = list.get(mid);
                l = mid + 1;
            }
        }
        int key = hm.getOrDefault(res, -1);
        if(key != -1){
            int left = res, right = hm.get(res);
            if(left <= q[0] && q[1] <= right) return true;
        }
        return false;
    }
}