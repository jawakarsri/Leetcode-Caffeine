/*
 * @lc app=leetcode id=2415 lang=java
 *
 * [2415] Reverse Odd Levels of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * This method reverses the values at odd levels of the binary tree.
     * 
     * Approach:
     * Use a helper method to traverse the tree in a level-order manner.
     * Swap the values of nodes at odd levels.
     * 
     * Time Complexity: O(n) - We visit each node exactly once.
     * Space Complexity: O(h) - The recursion stack can go as deep as the height of the tree.
     */
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return null;
        reverseOddLevelsHelper(root.left, root.right, 1);
        return root;
    }

    private void reverseOddLevelsHelper(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) return;

        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        reverseOddLevelsHelper(left.left, right.right, level + 1);
        reverseOddLevelsHelper(left.right, right.left, level + 1);
    }
}
// @lc code=end

