package december.week3;

import utils.TreeNode;

import java.util.Stack;

public class Day2_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack();
        Integer prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // here stack top is pointing to leftmost node of subtree
            // and root is null
            root = stack.pop();
            if (prev != null && root.val <= prev)
                return false;
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}
