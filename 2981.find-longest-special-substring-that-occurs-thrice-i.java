/*
 * @lc app=leetcode id=2981 lang=java
 *
 * [2981] Find Longest Special Substring That Occurs Thrice I
 */

// @lc code=start
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int l = 1, r = n;

        // If the smallest possible length doesn't satisfy the condition, return -1
        if (!helper(s, n, l)) return -1;

        // Binary search to find the maximum length
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (helper(s, n, mid)) l = mid;
            else r = mid;
        }

        return l;
    }

    private boolean helper(String s, int n, int x) {
        int[] cnt = new int[26]; // Array to count occurrences of each character
        int p = 0;

        for (int i = 0; i < n; i++) {
            // Move pointer p to the right until it matches the current character
            while (s.charAt(p) != s.charAt(i)) p++;
            // If the substring length is at least x, increment the count of the character
            if (i - p + 1 >= x) cnt[s.charAt(i) - 'a']++;
            // If any character occurs more than twice, return true
            if (cnt[s.charAt(i) - 'a'] > 2) return true;
        }

        return false;
    }
}

/*
Time Complexity:
- The `maximumLength` method performs a binary search, which takes O(log n) iterations.
- Each call to the `helper` method involves a linear scan of the string, which takes O(n) time.
- Therefore, the overall time complexity is O(n log n).

Space Complexity:
- The `helper` method uses an array of size 26 to count character occurrences, which takes O(1) space.
- The space complexity is O(1).
*/
// @lc code=end

