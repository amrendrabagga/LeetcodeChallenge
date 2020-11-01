package september.week4;

import java.util.Arrays;

public class Day4_LargestNumber {

    public String largestNumber(int[] nums) {
        String s[] = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (a, b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for (String t : s) {
            sb.append(t);
        }
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }

    public String largestNumberUsingStream(int[] nums) {
        String result = Arrays.stream(nums)
                .mapToObj(x -> String.valueOf(x))
                .sorted((a,b) -> (b+a).compareTo(a+b))
                .reduce((a,b) -> a+b)
                .get();
        return result.startsWith("0") ? "0" : result;
    }
    public static void main(String[] args) {
        System.out.println("31".compareTo("12"));

    }
}
