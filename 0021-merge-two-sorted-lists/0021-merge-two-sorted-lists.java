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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null ){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode tempL1 = list1;
        ListNode tempL2 = list2; 
        ListNode list = new ListNode();
        ListNode tempL = list;
        //
        if(tempL1.val <= tempL2.val){
                list.val = tempL1.val;
                tempL1 = tempL1.next;
            }else{
                list.val = tempL2.val;
                tempL2 = tempL2.next;
            }

        while(tempL1 != null && tempL2 != null){
            if(tempL1.val <= tempL2.val){
                tempL.next = new ListNode(tempL1.val);
                tempL1 = tempL1.next;
            }else{
                tempL.next = new ListNode(tempL2.val);
                tempL2 = tempL2.next;
            }
            tempL = tempL.next;
        }

        while(tempL1 != null){
            tempL.next = new ListNode(tempL1.val);
            tempL = tempL.next;
            tempL1 = tempL1.next;
        }

        while(tempL2 != null){
            tempL.next = new ListNode(tempL2.val);
            tempL = tempL.next;
            tempL2 = tempL2.next;
        }

        return list;

    }
}