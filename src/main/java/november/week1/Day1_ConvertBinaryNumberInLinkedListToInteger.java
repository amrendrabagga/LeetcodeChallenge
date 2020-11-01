package november.week1;

import utils.ListNode;

public class Day1_ConvertBinaryNumberInLinkedListToInteger {
    public int getDecimalValueEfficient(ListNode head) {
        if (head == null)
            return 0;
        int sum = 0;
        ListNode curr = head;
        while (curr != null) {
            sum = 2*sum + curr.val;
            curr = curr.next;
        }
        return sum;
    }

    public int getDecimalValue(ListNode head) {
        if (head == null)
            return 0;
        ListNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append("" + curr.val);
            curr = curr.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
