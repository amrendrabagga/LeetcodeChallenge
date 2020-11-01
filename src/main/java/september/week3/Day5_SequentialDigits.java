package september.week3;

import java.util.ArrayList;
import java.util.List;

public class Day5_SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList();
        String s = "123456789";
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                int num = Integer.parseInt(s.substring(j, j + i));
                if (num > high) return list;
                if (num >= low) list.add(num);
            }
        }
        return list;
    }
}
