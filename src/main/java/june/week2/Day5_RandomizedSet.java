package june.week2;

import java.util.*;

class Day5_RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    List<Integer> list;
    public Day5_RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            list.set(index, list.get(list.size()-1));// replace current pos val with last for O(1)
            // then remove last element
            map.put(list.get(index), index);
            list.remove(list.size()-1);// this will be O(1) as elem is last in list
            map.remove(val);
            return true;

        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your Day5_RandomizedSet object will be instantiated and called as such:
 * Day5_RandomizedSet obj = new Day5_RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
