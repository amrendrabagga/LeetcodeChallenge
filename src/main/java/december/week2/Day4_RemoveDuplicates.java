package december.week2;

public class Day4_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int s = 2, f = 2;
        while (f  < nums.length) {
            if (nums[f] != nums[s-2]) {
                nums[s++] = nums[f];
            }
            f++;
        }
        return s;
    }
}
