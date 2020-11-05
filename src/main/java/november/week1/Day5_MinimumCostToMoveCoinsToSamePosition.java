package november.week1;

public class Day5_MinimumCostToMoveCoinsToSamePosition {
    public int minCostToMoveChips(int[] position) {
        // moving all chips starting from last position to one and two by i-2 hop,
        // as it cost 0
        // then we can simply return position 1 or 2 having less no of chips
        if (position == null || position.length == 0)
            return 0;
        int count[] = new int[2];
        for (int i=position.length - 1; i>=0; i--) {
            if (position[i] % 2 == 0)
                count[1]++;
            else count[0]++;
        }
        return Math.min(count[0], count[1]);
    }
}
