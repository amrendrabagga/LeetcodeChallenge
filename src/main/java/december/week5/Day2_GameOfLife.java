package december.week5;

public class Day2_GameOfLife {
    private int dx[] = {1, -1, 0, 0, -1, -1, 1, 1};
    private int dy[] = {0, 0, 1, -1, 1, -1, -1, 1};
    public void gameOfLife(int[][] board) {
        // rule -  0 -> 1 when liveCount = 3
        // rule -  1 -> 0 when liveCount < 2 || liveCount > 3
        // for inplace
        // case when 1->0 convert cell to -1
        // case when 0->1 convert cell to +2
        // reason we only consider 1 for changing state so changing 0 to 2 wont make diff, further  converting 1 to -1, then taking absolute for counting lives around cell is ok
        // absolute wont make any difference,
        int m = board.length;
        int n = board[0].length;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                int liveCount = 0;
                for (int k=0; k<8; k++) {
                    if (isSafe(board, i + dx[k], j + dy[k], m, n)) {
                        liveCount++;
                    }
                }
                if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = -1;
                }
            }
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 1;
                if (board[i][j] == -1)
                    board[i][j] = 0;
            }
        }
    }
    private boolean isSafe(int [][]board, int i, int j, int m, int n) {
        return i >= 0 && i < m && j>=0 && j < n && Math.abs(board[i][j]) == 1;
    }
}
