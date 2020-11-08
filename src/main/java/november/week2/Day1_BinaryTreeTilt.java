package november.week2;

import utils.TreeNode;

public class Day1_BinaryTreeTilt {
    private int sum = 0;
    public int findTilt(TreeNode root) {
        findTiltUtils(root);
        return sum;
    }
    private int findTiltUtils(TreeNode root) {
        if (root == null)
            return 0;
        int left = findTiltUtils(root.left);
        int right = findTiltUtils(root.right);
        sum += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        Day1_BinaryTreeTilt obj = new Day1_BinaryTreeTilt();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(obj.findTilt(root));

    }
}
