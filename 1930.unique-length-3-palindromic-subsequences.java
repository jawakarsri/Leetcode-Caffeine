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

