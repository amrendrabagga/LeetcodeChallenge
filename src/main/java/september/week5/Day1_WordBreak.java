package september.week5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day1_WordBreak {
    Map<String, Boolean> map = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s))
            return true;
        if (map.containsKey(s))
            return map.get(s);
        for (int i=0; i<=s.length(); i++) {
            String t = s.substring(0, i);
            if (wordDict.contains(t) && wordBreak(s.substring(i), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        Day1_WordBreak obj = new Day1_WordBreak();
        System.out.println(obj.wordBreak("leetcodeleet", Arrays.asList("leet", "code", "leet")));
    }
}
