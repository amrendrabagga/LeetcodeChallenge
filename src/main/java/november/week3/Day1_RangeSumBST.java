package november.week3;

import utils.TreeNode;

public class Day1_RangeSumBST {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null || (root.val < low && root.val > high))
            return 0;

        int left = rangeSumBST(root.left, low, high);
        int right = rangeSumBST(root.right, low, high);
        if (root.val >= low && root.val <=high)
            sum += root.val;
        return sum;
    }
}
