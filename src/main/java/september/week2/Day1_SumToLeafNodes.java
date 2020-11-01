package september.week2;

import utils.TreeNode;

public class Day1_SumToLeafNodes {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        parseTreeTillLeaf(root, "");
        return sum;
    }

    private TreeNode parseTreeTillLeaf(TreeNode root, String s) {
        if (root == null)
            return null;
        s += root.val;
        TreeNode left = parseTreeTillLeaf(root.left, s);
        TreeNode right = parseTreeTillLeaf(root.right, s);
        if (left == null && right == null) {
//            System.out.println("-:" +s);
            sum += Integer.parseInt(s,2);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(1), null);
//       TreeNode root = new TreeNode(1,
//               new TreeNode(0, new TreeNode(0), new TreeNode(1)),
//               new TreeNode(1, new TreeNode(0), new TreeNode(1)));
       Day1_SumToLeafNodes obj = new Day1_SumToLeafNodes();
        System.out.println(obj.sumRootToLeaf(root));
    }
}
