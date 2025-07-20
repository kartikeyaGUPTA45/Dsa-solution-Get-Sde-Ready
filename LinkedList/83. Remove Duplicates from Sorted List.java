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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode dummyNode = new ListNode(-1000);
        ListNode prev = dummyNode;

        while(curr != null) {
            while(curr != null && prev.val == curr.val) {
                curr = curr.next;
            }

            prev.next = curr;
            prev = prev.next;

            if (curr != null) {
                curr = curr.next;
            }
        }

        return dummyNode.next;

    } 
}
