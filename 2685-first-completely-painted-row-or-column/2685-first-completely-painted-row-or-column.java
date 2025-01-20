class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] colCheck = new int[n];
        int[] rowCheck = new int[m];

        HashMap<Integer,int[]> map = new HashMap<>();

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                map.put(mat[row][col], new int[]{row, col});
            }
        }

        int count = -1;

        for(int i = 0; i < arr.length; i++) {
            int[] index = map.get(arr[i]);

            colCheck[index[1]]++;
            rowCheck[index[0]]++;
            count++;

            if(colCheck[index[1]] == m || rowCheck[index[0]] == n){
                break;
            }
        }
        return count;
    }
}