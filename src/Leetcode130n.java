public class Leetcode130n {
    int m, n;
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        //遍历顺序。从边界能遍历到的点都不用改变
        for (int i = 0; i < m; i++) {
            DFS(board, i, 0);
            DFS(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            DFS(board, 0, j);
            DFS(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void DFS(char[][] board, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') return;
        board[row][col] = 'T';
        for (int[] d : direction) {
            int newR = row + d[0], newC = col + d[1];
            DFS(board, newR, newC);
        }
    }
}
