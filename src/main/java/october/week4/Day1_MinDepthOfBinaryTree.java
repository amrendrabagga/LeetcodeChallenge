package october.week4;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Day1_MinDepthOfBinaryTree {
    int res = Integer.MAX_VALUE;
    // below is dfs approach
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        minDepthUtils(root, 1);
        return res;
    }
    private void minDepthUtils(TreeNode root, int count) {
        if (root == null) return;
        minDepthUtils(root.left, count + 1);
        minDepthUtils(root.right, count + 1);
        if (root.left == null && root.right == null)
            res = Math.min(res, count);
    }

    // using bfs approach, Efficient Approach
    // here return first level that contains node with left and right as null
    public int minDepthBFS(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
            int size = queue.size();
            level++;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return level;
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return level;
    }

}
