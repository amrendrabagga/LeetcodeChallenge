package june.week3;

import java.util.ArrayList;
import java.util.List;

public class Day3_SurroundedRegion {
    private static int horizontal[] = {0, 0, -1, 1};
    private static int vertical[]    = {-1 ,1, 0, 0};
    private static boolean flag = false;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int r = board.length;
        int c = board[0].length;

        boolean visited[][] = new boolean[r][c];
        List<Pair> list = new ArrayList<>();
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (board[i][j]=='O' && !visited[i][j]) {
                    DFS(board, visited, i, j, list);
                    // convert O to X if flag is false
                    if (!flag) {
                        convertRegion(board, list);
                    }
                    flag = false;
                    list.clear();
                }
            }
        }
    }

    private void DFS(char[][] board, boolean [][]visited, int i, int j, List<Pair> list) {
        if (i==0 || j==0 || i==board.length-1 || j==board[0].length-1)
            flag = true;
        visited[i][j] = true;
        list.add(new Pair(i, j));
        for (int k=0; k<4; k++) {
            if (isSafe(board, visited, i + horizontal[k], j + vertical[k])) {
                DFS(board, visited, i + horizontal[k], j + vertical[k], list);
            }
        }

    }

    private boolean isSafe(char[][] board, boolean [][]visited, int i, int j) {
        if (i>=0 && j >= 0 && i<board.length && j < board[0].length &&
                board[i][j]=='O' && !visited[i][j])
            return true;
        return false;
    }

    private void convertRegion(char[][] board, List<Pair> list) {
        for (Pair p : list) {
            board[p._1][p._2] = 'X';
        }
    }

    static class Pair {
        public int _1;
        public int _2;

        Pair(int i, int j) {
            this._1 = i;
            this._2 = j;
        }
    }


    public static void main(String[] args) {
        char board[][] = {{'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};

        Day3_SurroundedRegion obj = new Day3_SurroundedRegion();
        obj.solve(board);

        int r = board.length;
        int c = board[0].length;
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
