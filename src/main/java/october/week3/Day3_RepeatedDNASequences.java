package october.week3;

import java.util.*;

public class Day3_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 11) return new ArrayList<String>();
        Set<String> res = new HashSet();
        Map<String, Integer> cache = new HashMap();
        for (int i=0; i<=s.length()-10; i++) {
            String t = s.substring(i, i+10);
            if (cache.containsKey(t))
                res.add(s.substring(cache.get(t), cache.get(t) + 10));
            cache.put(t, i);
        }
        return new ArrayList(res);
    }

    public List<String> findRepeatedDnaSequencesEfficient(String s) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i=0; i<=s.length() - 10; i++) {
            String t = s.substring(i, i+10);
            if (set.contains(t) && !res.contains(t))
                res.add(t);
            else
                set.add(t);
        }
        return res;
    }
}
