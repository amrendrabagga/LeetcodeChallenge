package september.week1;

public class Day3_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len/2; i>=1; i--) {
            if (len % i == 0) {
                int repeats = len / i;
                String r = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j=0; j<repeats ;j++) {
                    sb.append(r);
                }
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
