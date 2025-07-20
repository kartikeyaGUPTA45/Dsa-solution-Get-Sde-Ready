class Solution {

    private ListNode findMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            ListNode backUp = curr.next;

            curr.next = prev;

            prev = curr;
            curr = backUp;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = findMiddleNode(head);
        ListNode newHead = mid.next;

        mid.next = null;

        newHead = reverse(newHead);

        ListNode p1 = head;
        ListNode p2 = newHead;


        while(p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}
