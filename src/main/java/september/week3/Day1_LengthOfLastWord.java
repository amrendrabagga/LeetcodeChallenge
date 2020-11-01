package september.week3;

public class Day1_LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) return 0;
        s = s.trim();
        return s.substring(s.lastIndexOf(" ")+1).length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
