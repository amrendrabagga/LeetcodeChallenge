package september.week2;

public class Day4_MaxProduct {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int finalMax = nums[0];
        for (int i=1; i<nums.length; i++) {
            int tmp = currMax;
            currMax = Math.max(Math.max(tmp * nums[i], currMin * nums[i]), nums[i]);
            currMin = Math.min(Math.min(currMin * nums[i], tmp * nums[i]), nums[i]);
            if (finalMax < currMax) {
                finalMax = currMax;
            }
        }
        return finalMax;
    }
}
