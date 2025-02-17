class Solution {
    public int numTilePossibilities(String tiles) {
        char[] tArr = tiles.toCharArray();
        Arrays.sort(tArr); // Sort to handle duplicates
        return backtrack(tArr, new boolean[tArr.length]);
    }
    
    private int backtrack(char[] tArr, boolean[] used) {
        int ans = 0;
        for (int i = 0; i < tArr.length; i++) {
            // Skip already used or duplicate entries
            if (used[i] || (i > 0 && tArr[i] == tArr[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            ans += 1 + backtrack(tArr, used); // Count current and recursive paths
            used[i] = false;
        }
        return ans;
    }
}