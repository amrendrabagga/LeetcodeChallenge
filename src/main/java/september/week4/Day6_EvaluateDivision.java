package september.week4;

import java.util.*;

public class Day6_EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Node>> adj = buildGraph(equations, values);
        double []result = new double[queries.size()];
        for (int i=0; i<queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), adj, new HashSet<String>());
        }
        return result;
    }
    private double dfs(String src, String des, Map<String, List<Node>> adj, Set<String> visited) {
        if (!(adj.containsKey(src) && adj.containsKey(des)))
            return -1;
        if (src.equals(des))
            return 1;
        visited.add(src);
        for (Node n : adj.get(src)) {
            if (!visited.contains(n.key)) {
                double ans = dfs(n.key, des, adj, visited);
                if (ans != -1)
                    return ans * n.val;

            }
        }
        return -1;
    }
    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> adj = new HashMap();
        for (int i=0; i<values.length; i++) {
            String src = equations.get(i).get(0);
            String des = equations.get(i).get(1);
            adj.putIfAbsent(src, new ArrayList());
            adj.putIfAbsent(des, new ArrayList());
            adj.get(src).add(new Node(des, values[i]));
            adj.get(des).add(new Node(src, 1 / values[i]));
        }
        return adj;
    }
    static class Node {
        String key;
        double val;
        public Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }
}
