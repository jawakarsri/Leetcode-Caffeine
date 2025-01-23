class Solution {
    public int countServers(int[][] grid) {
        int count = 0;

        int n = grid.length;
        int m = grid[0].length;

        int rowServers[] = new int[n];
        int colServers[] = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rowServers[i]++;
                    colServers[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (rowServers[i] > 1 || colServers[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}