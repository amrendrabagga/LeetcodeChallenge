package december.week2;

public class Day1_NumOfPairDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {

        int count[] = new int[60];
        for (int t : time) {
            count[t % 60]++;
        }
        int total = 0;
        if (count[0] != 0) {
            total += count[0] * (count[0] - 1)/2;
        }
        if (count[30] != 0) {
            total += count[30] * (count[30] - 1)/2;
        }
        for (int i=1; i<30; i++) {
            if (count[i] != 0 && count[60 - i] != 0)
                total += count[i] * count[60 - i];
        }
        return total;
    }

    public static void main(String[] args) {
        Day1_NumOfPairDivisibleBy60 obj = new Day1_NumOfPairDivisibleBy60();
        System.out.println(obj.numPairsDivisibleBy60(new int[]{30,20,150,100,40}));

    }
}
