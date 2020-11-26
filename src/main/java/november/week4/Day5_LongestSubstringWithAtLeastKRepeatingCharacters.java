package november.week4;

public class Day5_LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k <= 1) return n;

        int count[] = new int[26];
        for (char c: s.toCharArray()) count[c - 'a']++;

        int l = 0;
        while (l < n && count[s.charAt(l) - 'a'] >= k) l++;
        if (l >= n-1) return l;
        int l1 = longestSubstring(s.substring(0, l), k);
        while (l < n && count[s.charAt(l) - 'a'] < k) l++;
        int l2 = l < n ? longestSubstring(s.substring(l), k) : 0;
        return Math.max(l1, l2);
    }
}
