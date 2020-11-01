package june.week1;

import utils.ListNode;

public class Day2_DeleteLinkListNode {
    public void deleteNode(ListNode node) {

        ListNode prev = node;
        while (node.next!=null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }
}
