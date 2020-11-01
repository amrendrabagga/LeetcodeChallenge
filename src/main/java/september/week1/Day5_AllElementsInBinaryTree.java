package september.week1;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day5_AllElementsInBinaryTree {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stk1 = new Stack();
        Stack<TreeNode> stk2 = new Stack();
        pushLeft(root1, stk1);
        pushLeft(root2, stk2);

        List<Integer> res = new ArrayList();
        while (!stk1.isEmpty() || !stk2.isEmpty()) {
            TreeNode tmp;
            if (!stk1.isEmpty() && (stk2.isEmpty() || stk1.peek().val <= stk2.peek().val)) {
                tmp = stk1.pop();
                res.add(tmp.val);
                pushLeft(tmp.right, stk1);
            }
            else {
                tmp = stk2.pop();
                res.add(tmp.val);
                pushLeft(tmp.right, stk2);
            }
        }
        return res;
    }
    private void pushLeft(TreeNode root, Stack<TreeNode> stk) {
        // push current and all its left node
        TreeNode curr = root;
        while (curr != null) {
            stk.push(curr);
            curr = curr.left;
        }
    }
}
