package october.week3;

public class Day1_RotateArray {
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

    public void rotate(int[] nums, int d) {
        reverseArray(nums);
        // juggling algo
        d = d % nums.length;
        int g = gcd(nums.length, d);
        for (int i=0; i<g; i++) {
            int tmp = nums[i];
            int j = i;
            while (true) {
                int k = j + d;
                if (k >= nums.length)
                    k = k - nums.length;
                if (k == i)
                    break;
                nums[j] = nums[k];
                j = k;
            }
            nums[j] = tmp;
        }
        reverseArray(nums);
    }

    private void reverseArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int []nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
