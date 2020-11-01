package october.week2;

public class Day7_HouseRobber2 {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int n = nums.length;
        int odd = robUtils(nums, 0, n-2);
        int even = robUtils(nums, 1, n-1);
//        System.out.print(odd + "->" + even);
        return Math.max(odd, even);
    }

    private int robUtils(int []nums, int start, int end) {
        int dp[] = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start+1]);
        for (int i=start+2; i<=end; i++) {
            dp[i-start] = Math.max(dp[i-start-1], dp[i-start-2] + nums[i]);
        }
        return dp[end - start];
    }

    public static void main(String[] args) {
        Day7_HouseRobber2 obj = new Day7_HouseRobber2();
        System.out.println(obj.rob(new int[]{4,1,1,3,1}));

    }
}
