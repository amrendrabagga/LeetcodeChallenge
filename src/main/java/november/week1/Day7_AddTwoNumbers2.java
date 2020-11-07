package november.week1;

import utils.ListNode;

import java.util.Stack;

public class Day7_AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = listToStack(l1);
        Stack<Integer> stack2 = listToStack(l2);
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) sum += stack1.pop();
            if (!stack2.isEmpty()) sum += stack2.pop();
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
            carry = sum / 10;
        }
        return head;
    }

    private Stack<Integer> listToStack(ListNode h) {
        Stack<Integer> stack = new Stack();
        while (h != null) {
            stack.push(h.val);
            h = h.next;
        }
        return stack;
    }
}
