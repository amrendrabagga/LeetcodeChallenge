package december.week4;

public class Day2_NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char ch[] = (n + "").toCharArray();
        int i = ch.length - 2;
        while (i >= 0 && ch[i] >= ch[i+1]) i--;

        if (i == -1)
            return -1;
        int j = ch.length - 1;
        while (j > i && ch[i] >= ch[j]) j--;
        swap(ch, i, j);
        reverse(ch, i+1);
        try {
            return Integer.parseInt(new String(ch));// in case number gets beyond int range
        }
        catch (Exception e) {
            return -1;
        }
    }
    private void reverse(char ch[], int l) {
        int r = ch.length - 1;
        while (l < r) {
            swap(ch, l, r);
            l++;
            r--;
        }
    }
    private void swap(char ch[], int i, int j) {
        char tmp = ch[i];
        ch[i] = ch[j];
        ch[j] = tmp;
    }
}
