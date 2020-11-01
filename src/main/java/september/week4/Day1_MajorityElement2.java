package september.week4;

import java.util.ArrayList;
import java.util.List;

public class Day1_MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length/3;
        List<Integer> list = new ArrayList();
        int c1 = 0;
        int c2 = 0;
        Integer n1 = null;
        Integer n2 = null;
        for (int num : nums) {
            if (n1 != null && num == n1.intValue())
                c1++;
            else if (n2 != null && num == n2.intValue())
                c2++;
            else if (c1 == 0) {
                n1 = num;
                c1 = 1;
            }
            else if (c2 == 0) {
                n2 = num;
                c2 = 1;
            }
            else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == n1)
                c1++;
            else if (num == n2)
                c2++;
        }
        if (c1 > n)
            list.add(n1);
        if (c2 > n)
            list.add(n2);
        return list;
    }
}
