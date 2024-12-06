/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);  // Dummy node to simplify edge cases
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Move `first` n+1 steps ahead to create the necessary gap
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        // Move both `first` and `second` until `first` reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        // Remove the nth node from the end
        second.next = second.next.next;
        return dummy.next;  // Return the head of the modified list
    }
}
// Approach:
// 1. Use a dummy node to handle edge cases such as removing the head node.
// 2. Use two pointers, `first` and `second`, both starting at the dummy node.
// 3. Move `first` pointer n+1 steps ahead to create a gap of n nodes between `first` and `second`.
// 4. Move both pointers until `first` reaches the end of the list. At this point, `second` will be just before the node to be removed.
// 5. Adjust the `next` pointer of `second` to skip the nth node from the end.
// 6. Return the head of the modified list, which is `dummy.next`.
// Time Complexity: O(L), where L is the length of the linked list. We traverse the list twice, once to advance the `first` pointer and once to find the nth node from the end.
// Space Complexity: O(1), we use a constant amount of extra space.
// @lc code=end

