package december.week4;

import java.util.*;

public class Day6_JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> adj = new HashMap();
        for (int i=0; i<n; i++) {
            adj.computeIfAbsent(arr[i], l -> new ArrayList<>()).add(i);
        }
        int step = 0;
        Queue<Integer> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int i = queue.poll();
                if (n - 1 == i)
                    return step;
                List<Integer> adjList = adj.get(arr[i]);
                adjList.add(i-1);
                adjList.add(i+1);
                for (int j : adjList) {
                    if (j>=0 && j<n && !visited.contains(j)) {
                        queue.offer(j);
                        visited.add(j);
                    }
                }
                adjList.clear();
            }

            step++;
        }
        return -1;
    }
}
