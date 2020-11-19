package november.week3;

import java.util.Stack;

public class Day5_DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return s;
        Stack<Integer> counts = new Stack();
        Stack<String> result = new Stack();
        int index = 0;
        String res = "";

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index += 1;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                result.push(res);
                res = "";
                index += 1;
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i = 0; i<count; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index += 1;
            } else {
                res += s.charAt(index);
                index += 1;
            }
        }
        return res;
    }
}
