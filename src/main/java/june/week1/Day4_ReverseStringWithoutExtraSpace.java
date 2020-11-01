package june.week1;

public class Day4_ReverseStringWithoutExtraSpace {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left < right) {
            //a b c
            s[right] = (char)(s[left] ^ s[right]);// a b a^c
            s[left] = (char)(s[right] ^ s[left]);// a^c^a b a^c -> c b a^c
            s[right] = (char)(s[right] ^ s[left]);// c b a^c^c -> c b a
            left++;
            right--;
        }
    }
}
