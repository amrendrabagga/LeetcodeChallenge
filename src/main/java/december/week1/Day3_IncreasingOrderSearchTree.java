package december.week1;

import utils.TreeNode;

public class Day3_IncreasingOrderSearchTree {
    TreeNode current;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode dummyNode = new TreeNode(0);
        current = dummyNode;
        inorder(root);
        return dummyNode.right;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        root.left = null;
        current = current.right = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4, new TreeNode(5), new TreeNode(6)));
        root.right = new TreeNode(7);

        Day3_IncreasingOrderSearchTree obj = new Day3_IncreasingOrderSearchTree();
        System.out.println(obj.increasingBST(root));

    }

}
