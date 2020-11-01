package october.week4;

import java.util.Stack;

public class Day2_132Pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length == 0) return false;

        int minValue[] = new int[nums.length];
        minValue[0] = nums[0];

        for (int i=1; i<nums.length; i++)
            minValue[i] = Math.min(minValue[i-1], nums[i]);

        Stack<Integer> stack = new Stack();
        for (int j=nums.length-1; j>=0; j--) {
            if (nums[j] > minValue[j]) {
                while (!stack.isEmpty() && stack.peek() <= minValue[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
