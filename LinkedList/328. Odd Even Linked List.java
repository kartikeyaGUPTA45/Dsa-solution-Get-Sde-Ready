class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oDN = new ListNode(-1);
        ListNode eDN = new ListNode(-1);

        ListNode o = oDN;
        ListNode e = eDN;
        ListNode ptr = head;

        int count = 1;

        while(ptr != null) {
            if ((count&1) == 0) {
                e.next = ptr;
                e = e.next;
            } else {
                o.next = ptr;
                o = o.next;
            }

            ptr = ptr.next;
            count+=1;
        }

        o.next = eDN.next;
        e.next = null;

        return oDN.next;




    }
}
