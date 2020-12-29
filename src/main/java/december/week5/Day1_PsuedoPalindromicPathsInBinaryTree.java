package december.week5;

import utils.TreeNode;

public class Day1_PsuedoPalindromicPathsInBinaryTree {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;
        int counter[] = new int[9];
        pseudoPalindromicPathsUtils(root, counter);
        return count;
    }
    private TreeNode pseudoPalindromicPathsUtils(TreeNode root, int []counter) {
        if (root == null) return null;
        counter[root.val-1]++;
        TreeNode left = pseudoPalindromicPathsUtils(root.left, counter);
        TreeNode right = pseudoPalindromicPathsUtils(root.right, counter);
        if (left == null && right == null) {
            int odd = 0;
            int maxOdd = 0;
            for (int i=0; i<9; i++) {
                if (counter[i] % 2 != 0) {
                    maxOdd = Math.max(maxOdd, counter[i]);
                    odd += counter[i];
                }
            }
            // no is palindrom if we have
            // frequency of number being 1 or zero,
            // irrespective of frequency being even of any no
            // 112233445 -> 123454321
            // 11223344 -> 12344321
            // another special case if only odd frequency exist
            // ie 222, 555, 77777, 9999999
            if (odd < 2 || odd == maxOdd) {
                count++;
            }
        }
        counter[root.val-1]--;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3, new TreeNode(3), new TreeNode(1));
        root.right = new TreeNode(1, null, new TreeNode(1));
        Day1_PsuedoPalindromicPathsInBinaryTree obj = new Day1_PsuedoPalindromicPathsInBinaryTree();
        System.out.println(obj.pseudoPalindromicPaths(root));

    }
}
