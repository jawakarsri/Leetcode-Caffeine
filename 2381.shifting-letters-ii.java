/*
 * @lc app=leetcode id=2381 lang=java
 *
 * [2381] Shifting Letters II
 */

// @lc code=start
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
// @lc code=end

/*
 * Approach:
 * 1. Create an array to store the net shift amount for each character.
 * 2. Iterate through the shifts and update the shift amount array.
 * 3. Compute the prefix sum of the shift amount array.
 * 4. Apply the shifts to the string and construct the result.
 *
 * Time Complexity: O(n + m), where n is the length of the string and m is the number of shifts.
 * Space Complexity: O(n), where n is the length of the string.
 */

