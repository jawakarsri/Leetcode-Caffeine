class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int incoming[] = new int[n];
        HashMap<Integer,ArrayList> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            incoming[i]=graph[i].length;
            if(graph[i].length==0){
                q.add(i);
            }
            for(int num:graph[i]){
                if(map.containsKey(num)){
                    ArrayList<Integer> arr = new ArrayList<>(map.get(num));
                    arr.add(i);
                    map.put(num,arr);
                }else{
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    map.put(num,arr);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(q.size()>0){
            int a = q.poll();
            res.add(a);
            ArrayList<Integer> ar = new ArrayList<>();
            if(map.containsKey(a)){
                ar=map.get(a);
            }
            for(int num:ar){
                incoming[num]=incoming[num]-1;
                if(incoming[num]==0){
                    q.add(num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}