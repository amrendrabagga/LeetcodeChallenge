package october.week2;

import java.util.Stack;

public class Day4_RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int count[] = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack();
        boolean visited[] = new boolean[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (visited[c - 'a'])
                continue;

            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Day4_RemoveDuplicateLetters obj = new Day4_RemoveDuplicateLetters();
        System.out.println(obj.removeDuplicateLetters("bcacb"));
    }
}
