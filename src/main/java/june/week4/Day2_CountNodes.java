package june.week4;


import utils.TreeNode;

public class Day2_CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + right + left;

    }
}
