class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<int []> q = new LinkedList<>();
        int m = isWater.length, n = isWater[0].length, dirs[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int res[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){    
                if(isWater[i][j] == 1){
                    isWater[i][j] = -1;
                    q.add(new int[]{i, j});
                }
            }
        }
        int height = 0;
        while(!q.isEmpty()){
            height++;
            int s = q.size();
            while(s-->0){
                int a[] = q.poll();
                for(int dir[]: dirs){
                    int x = a[0] + dir[0], y = a[1] + dir[1];
                    if(x > -1 && y > -1 && x < m && y < n && isWater[x][y] != -1){
                        isWater[x][y] = -1;
                        res[x][y] = height;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
        return res;
    }
}