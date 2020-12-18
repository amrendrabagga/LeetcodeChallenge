package december.week3;

public class Day4_IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int suffix[] = new int[n + 1];
        suffix[n] = Integer.MIN_VALUE;
        int minToTheLeft = Integer.MAX_VALUE;
        int i = n - 1;
        while (i >= 0) {
            suffix[i] = Math.max(suffix[i + 1], nums[i]);
            i--;
        }

        for (int j = 0; j < n; j++) {
            if (minToTheLeft < nums[j] && nums[j] < suffix[j])
                return true;
            minToTheLeft = Math.min(minToTheLeft, nums[j]);
        }
        return false;
    }

    public boolean increasingTripletEfficient(int[] nums) {
        // left < mid < right
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > mid) {
                // if current element is greater than mid,
                // ie. we have found third element greater than 2 elements from left
                return true;
            }
            else if (num > left && num < mid) {
                // if current if greater than min from left,
                // but we also make sure that if we find num less than mid then we update
                // mid as to increase chance of getting number greater than mid ahead
                // ex 1, 5, 2, 4, left->1, mid->2, num->4
                mid = num;
            }
            else if (num < left) {// update min from left if we find current < left
                left = num;
            }
        }
        return false;
    }
}
