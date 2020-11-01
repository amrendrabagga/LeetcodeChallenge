package september.week1;

import java.util.HashMap;
import java.util.Map;

public class Day7_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split("\\s");
        if (words.length != pattern.length())
            return false;

        Map<Character, String> map = new HashMap();
        for (int i=0; i<words.length; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                String s = map.get(c);
                if (!s.equals(words[i]))
                    return false;
            }
            else if (map.containsValue(words[i])) {
                return false;
            }
            map.put(c, words[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Day7_WordPattern().wordPattern("abba", "dog cat cat dog"));
    }
}
