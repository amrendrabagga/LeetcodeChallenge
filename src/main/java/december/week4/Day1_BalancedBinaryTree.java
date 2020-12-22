package december.week4;

import utils.TreeNode;

public class Day1_BalancedBinaryTree {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        heightOfTree(root);
        return res;
    }
    private int heightOfTree(TreeNode root) {
        if (root == null) return 0;
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        if (Math.abs(lh - rh) > 1)
            res = false;
        return 1 + Math.max(lh, rh);
    }
}
