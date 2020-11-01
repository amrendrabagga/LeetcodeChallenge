package june.week2;

public class Day4_SortColors {
    // insertion sort
    public void sortColors(int[] nums) {

        for (int i=1; i<nums.length; i++) {
            int key = nums[i];
            int j = i-1;

            while (j>=0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;
        }
    }
}
