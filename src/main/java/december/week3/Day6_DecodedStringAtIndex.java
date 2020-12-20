package december.week3;

public class Day6_DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int n = S.length();
        for (int i=0; i<n; i++) {
            if (Character.isDigit(S.charAt(i))) {
                size = size * (S.charAt(i) - '0');
            }
            else {
                size++;
            }
        }
        for (int i=n-1; i>=0; i--) {
            char ch = S.charAt(i);
            K %= size;

            if (K == 0 && Character.isLetter(ch)) {
                return "" + ch;
            }
            if (Character.isDigit(ch)) {
                size = size / (ch - '0');
            }
            else {
                size--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Day6_DecodedStringAtIndex obj = new Day6_DecodedStringAtIndex();
        System.out.println(obj.decodeAtIndex("ajx37nyx97niysdrzice4petvcvmcgqn282zicpbx6okybw93vhk782unctdbgmcjmbqn25rorktmu5ig2qn2y4xagtru2nehmsp",976159153));
    }
}
