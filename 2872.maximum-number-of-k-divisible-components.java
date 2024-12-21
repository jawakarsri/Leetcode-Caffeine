/*
 * @lc app=leetcode id=2872 lang=java
 *
 * [2872] Maximum Number of K-Divisible Components
 */

// @lc code=start
class Solution {
    /**
     * Approach:
     * 1. Create an adjacency list to represent the graph.
     * 2. Use DFS to traverse the graph and calculate the sum of values in each component.
     * 3. If the sum of a component is divisible by k, increment the result counter.
     * 
     * Time Complexity: O(n + m) where n is the number of nodes and m is the number of edges.
     * Space Complexity: O(n + m) for the adjacency list and visited array.
     */
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Create an adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Initialize result array to store the count of k-divisible components
        int[] result = new int[1];
        // Initialize visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        dfs(0, graph, values, k, visited, result);
        return result[0];
    }

    private int dfs(int node, List<List<Integer>> graph, int[] values, int k, boolean[] visited, int[] result) {
        visited[node] = true;
        int sum = values[node];
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                sum += dfs(neighbor, graph, values, k, visited, result);
            }
        }
        if (sum % k == 0) {
            result[0]++;
            return 0;
        }
        return sum;
    }
}
// @lc code=end

