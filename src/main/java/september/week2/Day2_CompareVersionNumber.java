package september.week2;

public class Day2_CompareVersionNumber {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String []v2 = version2.split("\\.");
        int i = 0;
        int j=0;
        while (i < v1.length && j < v2.length) {
            int ver1 = Integer.parseInt(v1[i]);
            int ver2 = Integer.parseInt(v2[j]);
            if (ver1 > ver2) return 1;
            if (ver1 < ver2) return -1;
            i++;
            j++;
        }
        while (i < v1.length) {
            if (Integer.parseInt(v1[i]) != 0) return 1;
            i++;
        }

        while (j < v2.length) {
            if (Integer.parseInt(v2[j]) != 0) return -1;
            j++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Day2_CompareVersionNumber obj = new Day2_CompareVersionNumber();
        System.out.println(obj.compareVersion("0.1", "1.1"));
        System.out.println(obj.compareVersion("1.0.1", "1"));
        System.out.println(obj.compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(obj.compareVersion("1.01", "1.1"));
        System.out.println(obj.compareVersion("1.0", "1.0.0.0.0.0.0.0"));
    }
}
