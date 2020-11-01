package october.week3;

import utils.Node;

import java.util.*;

public class Day6_CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        // going with bfs, easier than dfs:)
        Map<Node, Node> map = new HashMap();
        map.put(node, new Node(node.val, new ArrayList<>()));

        Queue<Node> queue = new LinkedList();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (Node t : n.neighbors) {
                if (!map.containsKey(t)) {
                    map.put(t, new Node(t.val, new ArrayList<>()));
                    queue.offer(t);
                }
                map.get(n).neighbors.add(map.get(t));
            }
        }
        return map.get(node);
    }

    static class Node {
            public int val;
            public List<Node> neighbors;

            public Node() {
                val = 0;
                neighbors = new ArrayList<Node>();
            }

            public Node(int _val) {
                val = _val;
                neighbors = new ArrayList<Node>();
            }

            public Node(int _val, ArrayList<Node> _neighbors) {
                val = _val;
                neighbors = _neighbors;
            }
    }
}
