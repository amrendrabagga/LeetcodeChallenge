package november.week4;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Day7_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length ==0 || k < 1)
            return new int[]{};

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b-a);

        for (int i=0; i<k; i++) {
            pq.offer(nums[i]);
        }
        System.out.println(pq);

        int res[] = new int[nums.length - k + 1];
        res[0] = pq.peek();
        pq.remove(nums[0]);
        int j = 1;
        for (int i=k; i<nums.length && j < res.length; i++,j++) {
            pq.offer(nums[i]);
            res[j] = pq.peek();
            pq.remove(nums[i-k+1]);
        }
        return res;
    }

    public static void main(String[] args) {
        Day7_SlidingWindowMaximum obj = new Day7_SlidingWindowMaximum();
        System.out.println(Arrays.toString(obj.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }

}
