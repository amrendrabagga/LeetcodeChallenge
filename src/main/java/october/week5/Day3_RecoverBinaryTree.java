package october.week5;

import utils.TreeNode;

public class Day3_RecoverBinaryTree {
    TreeNode first, prev, middle, last = null;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        recoverTreeUtil(root);

        if (first != null && last != null) {
            int val = first.val;
            first.val = last.val;
            last.val = val;
        }
        else if (first != null && middle != null) {
            int val = first.val;
            first.val = middle.val;
            middle.val = val;
        }
    }
    private void recoverTreeUtil(TreeNode root) {
        if (root != null) {
            recoverTreeUtil(root.left);
            if (prev != null && root.val < prev.val) {
                if (first == null) {
                    first = prev;
                    middle = root;
                }
                else
                    last = root;
            }
            prev = root;
            recoverTreeUtil(root.right);
        }
    }
}
