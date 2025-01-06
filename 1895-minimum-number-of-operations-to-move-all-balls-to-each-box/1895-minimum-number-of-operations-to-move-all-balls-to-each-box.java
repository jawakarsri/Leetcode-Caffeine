class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] res = new int[n];

        int balls=0, moves = 0;
        for(int i=0; i<n; i++){
            res[i] = balls + moves;

            moves = res[i];

            balls += boxes.charAt(i) == '1' ? 1 : 0;
        }

        balls=0; moves = 0;
        for(int i=n-1; i>=0; i--){
            res[i] += balls + moves;

            moves = balls+moves;

            balls += boxes.charAt(i) == '1' ? 1 : 0;
        }

        return res;
    }
}
