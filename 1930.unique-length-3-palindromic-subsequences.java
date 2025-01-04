/*
 * @lc app=leetcode id=1930 lang=java
 *
 * [1930] Unique Length-3 Palindromic Subsequences
 */

// @lc code=start
class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> palindromes = new HashSet<>();
        int n = s.length();
        
        for (char c = 'a'; c <= 'z'; c++) {
            int left = s.indexOf(c);
            int right = s.lastIndexOf(c);
            
            if (left != -1 && right != -1 && right - left > 1) {
                Set<Character> uniqueChars = new HashSet<>();
                for (int i = left + 1; i < right; i++) {
                    uniqueChars.add(s.charAt(i));
                }
                for (char mid : uniqueChars) {
                    palindromes.add("" + c + mid + c);
                }
            }
        }
        
        return palindromes.size();
    }
}
// @lc code=end

/*
 * Approach:
 * - Iterate through each character from 'a' to 'z'.
 * - For each character, find its first and last occurrence in the string.
 * - If the character appears at least twice and there are characters in between,
 *   collect all unique characters between the first and last occurrence.
 * - Form palindromic subsequences with the collected characters and add them to a set.
 * - Return the size of the set, which represents the number of unique length-3 palindromic subsequences.
 *
 * Time Complexity: O(26 * n) = O(n), where n is the length of the string.
 * Space Complexity: O(26 + n) = O(n), for storing the set of palindromes and unique characters.
 */

