package june.week3;

public class Day6_KthPermutation {

    static String kthPermutation(String s, int k) {

        return permutation(s, k, 0, s.length()-1);
    }

    private static String permutation(String s, int k, int l, int r) {
        if (l == r) {
            if (k==0)
                return s;
        }

        String res = "";
        for(int i=l; i<=r;i++) {
            s = swap(s, l, i);
            res = permutation(s, k-1, l + 1, r);
            if(!res.equals("")) break;
            s = swap(s, l, i);
        }
    return res;
    }

    private static String swap(String s, int l, int r) {
        char[] string = s.toCharArray();
        char tmp = string[l];
        string[l] = string[r];
        string[r] = tmp;
        return String.valueOf(string);
    }

    public static void main(String[] args) {
        System.out.println(kthPermutation("123",3));
    }
}
