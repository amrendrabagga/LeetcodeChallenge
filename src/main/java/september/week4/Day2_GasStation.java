package september.week4;

public class Day2_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tank = 0;

        for (int i=0; i<gas.length; i++) {
            if (gas[i] < cost[i])
                continue;
            int start = i;
            tank = gas[start] - cost[start];
            int j = (i+1) % n;
            while (start != j) {
                tank += gas[j];
                if (tank < cost[j])
                    break;
                tank -= cost[j];
                j = (j+1) % n;
            }
            if (start == j)
                return start;
        }
        return -1;
    }

    public int canCompleteCircuitEfficient(int[] gas, int[] cost) {
        // main concern for us is that there should enough fuel to complete round trip
        // wherever we start from
        // which we check by calculating diff bw gas and cost
        // then only concern for us is to get first pos from where we can start

        int index = 0;
        int total = 0;
        int tank = 0;// add diff of present gas and going to next
        // if at any stage tank value is negative means start index must be changed
        for (int i=0; i<gas.length; i++) {
            int consume = gas[i] - cost[i];
            tank += consume;
            if (tank < 0) {
                index = i+1;
                tank = 0;
            }
            total += consume;
        }
        return total >= 0 ? index : -1;
    }

    public static void main(String[] args) {
        Day2_GasStation obj = new Day2_GasStation();
        System.out.println(obj.canCompleteCircuitEfficient(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
