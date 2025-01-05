class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftAmount = new int[n + 1];
        
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;
            
            shiftAmount[start] += direction;
            shiftAmount[end + 1] -= direction;
        }
        
        for (int i = 1; i < n; i++) {
            shiftAmount[i] += shiftAmount[i - 1];
        }
        
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shift = shiftAmount[i] % 26;
            result[i] = (char) ((result[i] - 'a' + shift + 26) % 26 + 'a');
        }
        
        return new String(result);
    }
}