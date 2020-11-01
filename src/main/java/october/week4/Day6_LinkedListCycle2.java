package october.week4;

import utils.ListNode;

public class Day6_LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (slow != fast) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = head;
        while (res != slow) {
            res = res.next;
            slow = slow.next;
        }
        return res;
    }
}
