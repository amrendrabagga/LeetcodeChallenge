package december.week3;

public class Day5_CherryPickII {
    private int dir[] = {-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        int cache[][][] = new int[grid.length][grid[0].length][grid[0].length];
        return cherryPickupUtils(grid, cache,0, 0, grid[0].length-1);
    }

    private int cherryPickupUtils(int [][]grid, int cache[][][], int index, int c1, int c2) {
        if (index == grid.length) return 0;
        if (cache[index][c1][c2] != 0) return cache[index][c1][c2];
        // at every step we try to calculate best cherry pick path
        int best = 0;
        for (int i=0; i<dir.length; i++) {
            for (int j=0; j<dir.length; j++) {
                int rb1 = c1 + dir[i], rb2 = c2 + dir[j];
                if (rb1 >= 0 && rb1 < grid[0].length && rb2 >= 0 && rb2 < grid[0].length) {
                    int cherry = grid[index][c1];
                    if (c1 != c2) {
                        cherry += grid[index][c2];
                    }
                    best = Math.max(best, cherry + cherryPickupUtils(grid, cache, index + 1, rb1, rb2));
                }
            }
        }
        return cache[index][c1][c2] = best;
    }
}
