package september.week1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Day4_PartitionLabel {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Pair> map = new LinkedHashMap<>();

        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);

            map.put(c, map.getOrDefault(c, new Pair(i, i)).setEnd(i));
        }
//        System.out.println(map);
        List<Integer> res = new ArrayList();
        int start = 0;

        int max = map.get(S.charAt(0)).end;
        for (Map.Entry<Character, Pair> entry : map.entrySet()) {
            int currStart = entry.getValue().start;
            int currEnd = entry.getValue().end;

            if (max < currStart) {
                res.add(max - start + 1);
                start = currStart;
            }

            max = Math.max(max, currEnd);
        }
        res.add(max - start + 1);
        return res;
    }

    static class Pair {
        int start;
        int end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public Pair setStart(int start) {
            this.start = start;
            return this;
        }
        public Pair setEnd(int end) {
            this.end = end;
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Pair{");
            sb.append("start=").append(start);
            sb.append(", end=").append(end);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
     Day4_PartitionLabel obj = new Day4_PartitionLabel();
        System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
