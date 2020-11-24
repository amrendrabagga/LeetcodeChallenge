package november.week4;

import java.util.HashSet;
import java.util.Set;

public class Day1_UniqueMorseCodeWords {
    String[] encoding = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(encoding[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
