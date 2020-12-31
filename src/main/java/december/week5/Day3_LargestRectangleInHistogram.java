package december.week5;

import java.util.Stack;

public class Day3_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        int area = 0;
        int i = 0;
        for (; i<heights.length;) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            }
            else {
                //
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = heights[top] * i;
                }
                else {
                    area = heights[top] * (i - 1 - stack.peek());
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        // in case heights are in ascending order, [1,2,3,4,5]
        // or all elements in stack represent increasing heights
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = heights[top] * i;
            }
            else {
                area = heights[top] * (i - 1 - stack.peek());
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Day3_LargestRectangleInHistogram obj = new Day3_LargestRectangleInHistogram();
        System.out.println(obj.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

}
