package november.week2;

import utils.TreeNode;

public class Day2_MaximumDifferenceBetweenNodeAndAncestor {
    int result = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return result;
    }

    private void dfs(TreeNode root, int cmin, int cmax) {
        if (root == null)
            return;
        result = Math.max(result, Math.max(Math.abs(root.val - cmin), Math.abs(root.val - cmax)));
        cmin = Math.min(cmin, root.val);
        cmax = Math.max(cmax, root.val);
        dfs(root.left, cmin, cmax);
        dfs(root.right, cmin, cmax);
    }
}
