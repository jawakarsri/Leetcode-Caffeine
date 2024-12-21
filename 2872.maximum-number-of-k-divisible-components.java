/*
 * @lc app=leetcode id=2872 lang=java
 *
 * [2872] Maximum Number of K-Divisible Components
 */

// @lc code=start
class Solution {
    private int cnt = 0;

    private void getSubtree(int node, List<List<Integer>> adj, int par, long[] subtree) {
        if (adj.get(node).size() == 1 && adj.get(node).get(0) == par) {
            return;
        }
        for (int it : adj.get(node)) {
            if (it != par) {
                getSubtree(it, adj, node, subtree);
                subtree[node] += subtree[it];
            }
        }
    }

    private void dfs(int node, List<List<Integer>> adj, int par, long[] subtree, int k) {
        if (adj.get(node).size() == 1 && adj.get(node).get(0) == par) {
            return;
        }
        for (int it : adj.get(node)) {
            if (it != par) {
                long parSubtree = subtree[node] - subtree[it];
                long childSubtree = subtree[it];
                if (parSubtree % k == 0 && childSubtree % k == 0) {
                    cnt++;
                    subtree[node] -= subtree[it];
                } else {
                    subtree[it] = subtree[node];
                }
                dfs(it, adj, node, subtree, k);
            }
        }
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        long[] subtree = new long[n];
        for (int i = 0; i < n; i++) {
            subtree[i] = values[i];
        }

        getSubtree(0, adj, -1, subtree);
        dfs(0, adj, -1, subtree, k);
        return cnt + 1;
    }
}
// @lc code=end

