package september.week2;

public class Day3_BullsAndCows {
    public String getHint(String secret, String guess) {
        int count[] = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i=0; i<guess.length(); i++) {
            int n = secret.charAt(i) - '0';
            int m = guess.charAt(i) - '0';
            if (n == m) {
                bulls++;
                // count[secret.charAt(i) - '0'] -= 1;
            }
            else {
                if (count[n] < 0) cows++;// already processed
                if (count[m] > 0) cows++;
                count[n]++;
                count[m]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        Day3_BullsAndCows obj = new Day3_BullsAndCows();
        System.out.println(obj.getHint("11", "10"));
    }
}
