package november.week1;

import utils.ListNode;

public class Day2_InsertionSortList {
    ListNode sorted;
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;// we will use current node to place in newly created link list
            // thus its position whould not affect original link list traversal
            insertSorted(current);
            current = next;
        }
        head = sorted;
        return head;
    }
    private void insertSorted(ListNode newNode) {
        if (sorted == null || sorted.val > newNode.val) {
            newNode.next = sorted;
            sorted = newNode;
        }
        else {
            ListNode current = sorted;
            while (current.next != null && current.next.val < newNode.val) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
}
