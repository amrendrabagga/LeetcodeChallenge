package october.week1;

import java.util.LinkedList;
import java.util.Queue;

public class Day1_RecentCounterEfficient {

    Queue<Integer> queue;
    public Day1_RecentCounterEfficient() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < (t - 3000)) {
            queue.remove();
        }
        return queue.size();
    }
}
