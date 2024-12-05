/*
 * @lc app=leetcode id=2337 lang=java
 *
 * [2337] Move Pieces to Obtain a String
 *
 * This file contains the solution for the LeetCode problem 2337, which involves determining
 * if it is possible to move pieces in a given start string to match a target string.
 */

// @lc code=start
class Solution {
    public boolean canChange(String start, String target) {
        if (start.equals(target)) {
            return true;
        }
        int waitL = 0;
        int waitR = 0;
        
        for (int i = 0; i < start.length(); i++) {
            char curr = start.charAt(i);
            char goal = target.charAt(i);
            
            if (curr == 'R') {
                if (waitL > 0) {
                    return false;
                }
                waitR++;
            }
            if (goal == 'L') {
                if (waitR > 0) {
                    return false;
                }
                waitL++;
            }
            if (goal == 'R') {
                if (waitR == 0) {
                    return false;
                }
                waitR--;
            }
            if (curr == 'L') {
                if (waitL == 0) {
                    return false;
                }
                waitL--;
            }
        }
        
        return waitL == 0 && waitR == 0;
    }
}

// @lc code=end

/*
 * Time Complexity
 * The time complexity of this solution is O(n), where n is the length of the start string. This is because we iterate through each character of the start string exactly once.
 *
 * Space Complexity
 * The space complexity of this solution is O(1). We are using a constant amount of extra space (the waitL and waitR counters), regardless of the input size.
 */

