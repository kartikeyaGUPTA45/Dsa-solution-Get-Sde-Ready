class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;

        mid.next = null;

        l1 = sortList(l1);
        l2 = sortList(l2);

        return mergeTwoLists(l1, l2);
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummyNode = new ListNode(-1);
        ListNode k = dummyNode;
        ListNode i = list1;
        ListNode j = list2;


        while(i != null && j != null) {
            if (i.val <= j.val) {
                k.next = i;
                i = i.next;
            } else {
                k.next = j;
                j = j.next;
            }

            k = k.next;
        }

        k.next = (i == null) ? j : i;

        return dummyNode.next;
    }
}
