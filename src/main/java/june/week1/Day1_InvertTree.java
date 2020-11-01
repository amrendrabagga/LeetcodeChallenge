package june.week1;

import utils.TreeNode;

public class Day1_InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        root = swap(root);
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
    private TreeNode swap(TreeNode root) {
        if (root==null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public static void main(String[] args) {
        //create tree and judge
    }
}
