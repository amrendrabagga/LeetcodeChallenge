package december.week2;

import utils.TreeNode;

import java.util.Stack;

public class Day2_BinarySearchTreeIterator {
    Stack<TreeNode> stack;
    public Day2_BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack();
        leftMostInorder(root);
    }

    public int next() {
        TreeNode inorderPredecessor = stack.pop();
        if (inorderPredecessor.right != null) {
            leftMostInorder(inorderPredecessor.right);
        }
        return inorderPredecessor.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }

    private void leftMostInorder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
