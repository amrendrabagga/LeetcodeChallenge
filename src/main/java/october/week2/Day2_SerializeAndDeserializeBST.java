package october.week2;

import utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Day2_SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeUtils(root).trim();
    }
    private String serializeUtils(TreeNode root) {
        return root == null ? " null" : " " + root.val + serializeUtils(root.left) + serializeUtils(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList(Arrays.asList(data.split("\\s")));
        return deserializeUtils(queue);
    }
    private TreeNode deserializeUtils(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = deserializeUtils(queue);
        node.right = deserializeUtils(queue);
        return node;
    }
}
