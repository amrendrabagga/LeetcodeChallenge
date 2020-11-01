package october.week2;

public class Day1_BinarySearch {
    public int search(int[] nums, int target) {
        // if (target > nums[nums.length - 1])
        // return -1;
        int low = 0;
        int high = nums.length;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Day1_BinarySearch obj = new Day1_BinarySearch();
        System.out.println(obj.search(new int[]{-1,0,3,5,9,12}, 2));
    }
}
