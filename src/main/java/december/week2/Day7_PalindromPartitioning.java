package december.week2;

import java.util.ArrayList;
import java.util.List;

public class Day7_PalindromPartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        List<String> tmp = new ArrayList();
        partitionUtils(s, res, tmp);
        System.out.println(res);
        return res;
    }

    private void partitionUtils(String s, List<List<String>> res, List<String> tmp) {
        if (s.length() == 0) {
            res.add(new ArrayList<String>(tmp));
        }
        else {
            for (int i=0; i<s.length(); i++) {
                String left = s.substring(0, i+1);
                if (isPalindrom(left)) {
                    tmp.add(left);
                    partitionUtils(s.substring(i+1), res, tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrom(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
