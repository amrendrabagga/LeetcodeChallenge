package december.week2;

import utils.TreeNode;

public class Day5_SmallestSubtreeWithAllDeepestNodes {
    TreeNode result = null;
    int maxDepth = -1;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        postOrder(root, 0);
        return result;
    }
    private int postOrder(TreeNode root, int depth) {
        if (root == null) return depth;
        int left = postOrder(root.left, depth + 1);
        int right = postOrder(root.right, depth + 1);
        if (left == right) {
            maxDepth = Math.max(maxDepth, left);
            if (left == maxDepth)
                result = root;
        }
        return Math.max(left, right);
    }
}
