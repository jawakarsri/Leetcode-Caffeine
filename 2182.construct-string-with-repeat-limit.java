/*
 * @lc app=leetcode id=2182 lang=java
 *
 * [2182] Construct String With Repeat Limit
 */

// @lc code=start
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Count the frequency of each character
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        int i = 25; // Start from the largest character
        
        while (true) {
            int useCount = 0;
            // Find the next available character
            while (i >= 0 && count[i] == 0) {
                i--;
            }
            if (i < 0) break; // No more characters available
            
            // Append the character up to repeatLimit times
            while (useCount < repeatLimit && count[i] > 0) {
                result.append((char) (i + 'a'));
                count[i]--;
                useCount++;
            }
            
            // If there are still characters left, append the next smaller character
            if (count[i] > 0) {
                int j = i - 1;
                while (j >= 0 && count[j] == 0) {
                    j--;
                }
                if (j < 0) break; // No more smaller characters available
                result.append((char) (j + 'a'));
                count[j]--;
            }
        }
        
        return result.toString();
    }
}
// @lc code=end

/*
 * Approach:
 * 1. Count the frequency of each character in the input string.
 * 2. Use a StringBuilder to construct the result string.
 * 3. Iterate from the largest character to the smallest, appending characters up to the repeat limit.
 * 4. If the repeat limit is reached, append the next smaller character to break the sequence.
 * 5. Continue until all characters are used.
 *
 * Time Complexity: O(n), where n is the length of the input string.
 * Space Complexity: O(1), since the frequency array size is constant (26).
 */

