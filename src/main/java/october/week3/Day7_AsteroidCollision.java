package october.week3;

import java.util.Stack;

public class Day7_AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length <= 1)
            return asteroids;
        Stack<Integer> stack = new Stack();
        for (int ast : asteroids) {
            if (ast > 0) {
                stack.push(ast);
            }
            else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(stack.peek()) < Math.abs(ast))
                    stack.pop();

                if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(ast);

                if (stack.peek() == Math.abs(ast))
                    stack.pop();
            }
        }
        int res[] = new int[stack.size()];
        for (int i=res.length-1; i>=0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
