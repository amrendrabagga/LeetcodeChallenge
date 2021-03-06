package december.week4;

import utils.ListNode;

public class Day3_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        head = curr;
        while (true) {
            ListNode next = curr.next;
            curr.next = prev;
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }
            prev.next = next.next;
            prev = next;
            curr = prev.next;
        }
        return head;
    }
}
