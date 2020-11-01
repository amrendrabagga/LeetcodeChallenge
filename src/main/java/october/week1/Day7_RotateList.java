package october.week1;

import utils.ListNode;

public class Day7_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        int r = k % count;
        if (r == 0) return head;
        int i = count - r;
        tmp = head;
        ListNode in = tmp;
        while (i-- > 1) {
            tmp = tmp.next;
        }
        ListNode res = tmp.next;
        ListNode t = res;
        while (t.next != null) {
            t = t.next;
        }
        tmp.next = null;
        t.next = in;
        return res;
    }
}
