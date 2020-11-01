package june.week2;

public class Day2_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        int j = 0;
        int i = 0;
        while (j < t.length()) {
            char c = s.charAt(i);
            if (c == t.charAt(j)) {
                if (i == s.length()-1)
                    return true;
                i++;
            }
            j++;
        }
        return false;
    }
}
