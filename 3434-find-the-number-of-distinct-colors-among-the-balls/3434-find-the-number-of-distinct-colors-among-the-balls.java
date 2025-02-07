class Solution {
    public int[] queryResults(int limit, int[][] queries) {

        int[] ans = new int[queries.length];
        HashMap <Integer, Integer> map1 = new HashMap<>();
        HashMap <Integer, Integer> map2 = new HashMap<>();

        for(int i=0; i<queries.length; i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            if(!map1.containsKey(ball)){
                map1.put(ball,color);
                map2.put(color, map2.getOrDefault(color, 0) +1);
            }
            else{
               int colors =  map1.get(ball);
               if(map2.get(colors) < 2){
                map1.remove(ball);
                map2.remove(colors);
               }
               else{
                map1.remove(ball);
                map2.put(colors, map2.get(colors)-1);
               }
               map1.put(ball,color);
               map2.put(color, map2.getOrDefault(color, 0) +1);

            }
            ans[i] = map2.size();
            // System.out.println(map1);
            //  System.out.println(map2);

        }
        return ans;
    }
}