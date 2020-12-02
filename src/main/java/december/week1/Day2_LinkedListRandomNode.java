package december.week1;

import utils.ListNode;

public class Day2_LinkedListRandomNode {
    ListNode head;
    public Day2_LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value.
     * Used Resoviour Sampling, finding probablity of when input size is undefined.
     * for k elements having probablity for each as k/i(with i as input size)
     * then iterate rest of element(k-i) with increasing scope of size thus decreasing probablity
     * in our case we start with k=1*/
    public int getRandom() {
        int scope = 1;
        ListNode curr = head;
        int res = 0;
        while (curr != null) {
            if (Math.random() < 1.0/scope)
                res = curr.val;
            scope += 1;
            curr = curr.next;
        }
        return res;
    }
}
