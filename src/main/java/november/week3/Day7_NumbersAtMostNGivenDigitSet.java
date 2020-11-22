package november.week3;

import java.util.Arrays;

public class Day7_NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        // given length of digits as m, then no of numbers can be created less than n is
        // m + m^2 + m^3 + m^4 .... till it is less than n
        if (digits == null || digits.length == 0)
            return 0;
        Arrays.sort(digits);
        int count = 0;
        String ns = String.valueOf(n);

        for (int i=1; i<=ns.length() - 1; i++) {
            count += Math.pow(digits.length, i);
            System.out.println(Math.pow(digits.length, i) + " + ");
        }

        int i=0;
        while (i < ns.length()) {
            int j=0;
            while (j < digits.length && digits[j].compareTo(String.valueOf(ns.charAt(i))) < 0) {
                count += Math.pow(digits.length, ns.length() - i - 1);
                System.out.println(digits[j] + " + " + Math.pow(digits.length, ns.length() - i - 1) + " + ");
                j++;
            }
            if (j == digits.length || digits[j].compareTo(String.valueOf(ns.charAt(i))) > 0)
                return count;
            i++;
        }
        // if (i == digits.length)
        count++;
        return count;
    }

    public static void main(String[] args) {
        Day7_NumbersAtMostNGivenDigitSet obj = new Day7_NumbersAtMostNGivenDigitSet();
        System.out.println(obj.atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 5167));
    }
}
