package september.week3;

import java.util.HashSet;

public class Day2_MaximumXOROfTwoNumberInArray {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i=30; i>=0; i--) {
            mask = mask | (1<<i);
            for (int j=0; j<nums.length; j++) {
                
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1<<31);

    }
}
