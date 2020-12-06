package december.week1;


public class Day6_PopulatingEachPointerInEachNode2 {
    public Node connect(Node root) {
        Node node = root;
        while (node != null) {
            Node dummy = new Node(0);
            Node curr = dummy;
            while (node != null) {
                if (node.left != null) {
                    curr.next = node.left;
                    curr = curr.next;
                }
                if (node.right != null) {
                    curr.next = node.right;
                    curr = curr.next;
                }
                node = node.next;
            }
            // here dummy.next points to left node of current level,
            // so in next loop it starts from left to right on same level
            node = dummy.next;
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        Day6_PopulatingEachPointerInEachNode2 obj = new Day6_PopulatingEachPointerInEachNode2();
        System.out.println(obj.connect(root));

    }
}
