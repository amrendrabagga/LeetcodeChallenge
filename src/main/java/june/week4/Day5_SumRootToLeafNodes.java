package june.week4;


import utils.TreeNode;

public class Day5_SumRootToLeafNodes {
    public int sumNumbers(TreeNode root) {
        return calculateSumToLeaf(root, 0);
    }
    private int calculateSumToLeaf(TreeNode root, int ans) {
        if (root == null) return 0;

        int newans = ans*10 + root.val;

        if (root.left == null && root.right == null) {
            return newans;
        }
        return calculateSumToLeaf(root.left, newans) + calculateSumToLeaf(root.right, newans);
    }
}
