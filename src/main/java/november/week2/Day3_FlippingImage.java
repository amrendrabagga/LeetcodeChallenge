package november.week2;

public class Day3_FlippingImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0)  return A;
        for (int[] nums : A) {
            int i=0; int j = nums.length-1;
            while (i < j) {
                int tmp = nums[i];
                nums[i] = 1 ^ nums[j];
                nums[j] = 1 ^ tmp;
                i++;j--;
            }
            if (nums.length % 2 != 0)
                nums[i] ^= 1;
        }
        return A;
    }
}
