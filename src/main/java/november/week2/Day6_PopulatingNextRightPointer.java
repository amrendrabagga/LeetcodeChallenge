package november.week2;

public class Day6_PopulatingNextRightPointer {

    public Node connect(Node root) {
        if (root == null || root.left == null || root.right == null)
            return root;
        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
