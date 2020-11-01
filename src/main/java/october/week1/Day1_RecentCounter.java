package october.week1;

import java.util.LinkedList;

public class Day1_RecentCounter {

    LinkedList<Integer> list;
    int last = 0;
    public Day1_RecentCounter() {
        list = new LinkedList();
    }

    public int ping(int t) {
        list.add(t);
        int i = t - 3000;
        if (i <= 0) return list.size();
        while (last < list.size() && list.get(last) < i) {
            last++;
        }
        return list.size() - last;
    }
}
