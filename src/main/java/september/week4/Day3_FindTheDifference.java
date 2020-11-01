package september.week4;

public class Day3_FindTheDifference {
    public char findTheDifference(String s, String t) {
        int []count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (count[c - 'a'] > 0)
                count[c - 'a']--;
            else return c;
        }
        return 'a';
    }
}
