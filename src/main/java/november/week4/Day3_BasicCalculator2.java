package november.week4;

import java.util.Stack;

public class Day3_BasicCalculator2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        char op = '+';
        Stack<Integer> stk = new Stack();
        int curr = 0;
        char ch[] = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                curr = curr * 10 + ch[i] - '0';
            }
            if (!Character.isDigit(ch[i]) && ch[i] != ' ' || i == ch.length - 1) {
                if (op == '+')
                    stk.push(curr);
                else if (op == '-')
                    stk.push(-curr);
                else if (op == '*')
                    stk.push(stk.pop() * curr);
                else stk.push(stk.pop() / curr);
                op = ch[i];
                curr = 0;
            }
        }
        int sum = 0;
        while (!stk.isEmpty()) {
            sum += stk.pop();
        }
        return sum;
    }

    public int calculateEfficient(String s) {
        if (s == null || s.length() == 0) return 0;
        int last = 0;
        int curr = 0;
        int sum = 0;
        char ch[] = s.toCharArray();
        char op = '+';
        for (int i=0; i<ch.length; i++) {
            if (Character.isDigit(ch[i])) {
                curr = curr * 10 + ch[i] - '0';
            }
            if (!Character.isDigit(ch[i]) && ch[i] == ' ' || i == ch.length - 1) {
                if (op == '+') {
                    sum += last;
                    last = curr;
                }
                else if (op == '-') {
                    sum += last;
                    last = curr;
                }
                else if (op == '*')
                    last = last * curr;
                else
                    last = last / curr;
                op = ch[i];
                curr = 0;
            }
        }
        sum += last;
        return sum;
    }
}
