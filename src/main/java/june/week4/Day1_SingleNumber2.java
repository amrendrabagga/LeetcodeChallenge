package june.week4;

public class Day1_SingleNumber2 {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i=0; i<32; i++) { // since int is 32 bit long
            int count = 0;
            for (int j=0; j<nums.length; j++) {
                if ((nums[j] & (1 << i)) != 0)
                    count++;
            }
            result = result | ((count%3) << i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,3,2,2}));
    }
}
