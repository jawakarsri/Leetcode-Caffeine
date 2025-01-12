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
      static ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode list1 = reverse(l1);
        ListNode list2 = reverse(l2);

        ListNode dummy = new ListNode(100);
        ListNode dtemp = dummy;

    int carry = 0;
    while(list1 != null || list2 != null || carry >= 1){
        int sum = 0;

        if(list1 != null){
            sum = sum + list1.val;
            list1 = list1.next;
        }

        if(list2 != null){
            sum = sum + list2.val;
            list2 = list2.next;
        }

        sum = sum + carry;
        carry = sum/10;          //upate carry value;
        
        ListNode newnode = new ListNode();
        newnode.val = sum % 10;
        dtemp.next = newnode;
        dtemp = dtemp.next;

    }
    return reverse(dummy.next);
    }

}