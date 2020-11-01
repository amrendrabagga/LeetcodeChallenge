package september.week1;

import java.util.ArrayList;
import java.util.List;

public class Day1_LargestTimeForGivenDigits {

    public String largestTimeFromDigits(int[] A) {
        List<String> list = new ArrayList();
        String s = "";
        for (int i : A) {
            s += i;
        }
        permutations(s, 0, 3, list);

        String res = "";
        for (String p : list) {
            String HH = p.substring(0,2);
            String MM = p.substring(2);
            if (HH.compareTo("24") < 0 && MM.compareTo("60") < 0 && res.compareTo(HH + ":" + MM) < 0)
                res = HH + ":" + MM;
        }
        return res;
    }

    private void permutations(String s, int l, int r, List<String> list) {
        if (l == r) list.add(s);
        for (int i=l; i<=r; i++) {
            s = swap(s, l, i);
            permutations(s, l+1, r, list);
            s = swap(s, l, i);
        }
    }

    private String swap(String s, int l, int r) {
        char[] c = s.toCharArray();
        char tmp = c[l];
        c[l] = c[r];
        c[r] = tmp;
        return String.valueOf(c);
    }

   

    public static void main(String[] args) {
        Day1_LargestTimeForGivenDigits obj = new Day1_LargestTimeForGivenDigits();
        System.out.println(obj.largestTimeFromDigits(new int[]{0,2,6,6}));
    }
}
