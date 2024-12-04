class Solution {
    private void DFS(int node, Map<Integer, List<Integer>> map, List<Integer> eulerCircuit){
        while(map.containsKey(node) && !map.get(node).isEmpty()){
            int nextNode = map.get(node).remove(map.get(node).size() - 1);
            DFS(nextNode, map, eulerCircuit);
        }
        eulerCircuit.add(node);
    }


    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        for(int[] pair : pairs){
            int u = pair[0];
            int v = pair[1];

            map.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        int start = pairs[0][0];
        for(int node : map.keySet()){
            if(outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1){
                start = node;
                break;
            }
        }

        List<Integer> eulerCircuit = new ArrayList<>();
        DFS(start, map, eulerCircuit);

        Collections.reverse(eulerCircuit);

        int[][] result = new int[eulerCircuit.size() - 1][2];
        for(int i = 0; i < eulerCircuit.size() - 1; i++){
            result[i][0] = eulerCircuit.get(i);
            result[i][1] = eulerCircuit.get(i + 1);
        }

        return result;
    }
}