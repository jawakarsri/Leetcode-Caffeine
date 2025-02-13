class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i:nums){
            pq.add((long)i);
        }
        int ans=0;
        while(pq.peek()<k){
            long x=(pq.poll())*2+pq.poll();
            // int y=pq.poll()
            pq.offer(x);
            ans++;

        }
        return ans;

        
    }
}