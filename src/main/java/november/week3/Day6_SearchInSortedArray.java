package november.week3;

public class Day6_SearchInSortedArray {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums[0] < nums[nums.length - 1])
            return binarySearch(nums, target);
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target) {
                return true;
            }
            // special case is covered here ex - nums - [1,3,1,1,1] and target -3
            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            else if (nums[low] <= nums[mid]) { // considering repeated element
                if (target >= nums[low] && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // low and mid are not sorted then automatically other half is sorted
            else {
                if (target >= nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }

        }
        return false;
    }
    private boolean binarySearch(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (nums[mid] == target)
                return true;
            else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Day6_SearchInSortedArray obj = new Day6_SearchInSortedArray();
        System.out.println(obj.search(new int[]{1,3,1,1,1}, 3));
    }

}
