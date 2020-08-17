public class Leetcode130 {
    int m, n;
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /*本题反映了三个问题
     * 1、m,n未赋值时不可new boolean[][] vis
     * 2、if (board[row][col] == 'X' || vis[row][col])前需先判断是否越界
     * 3、flag = flag||DFS() 当flag为true时不计算DFS()
     * */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        m = board.length;
        n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && vis[i][j] == false) {
                    System.out.println("hah" + i + " " + j);
                    if (!DFS(board, vis, i, j)) {//被包围的替换
                        System.out.println(i + " " + j);
                        DFS2(board, i, j);
                    }
                }
            }
        }
    }

    //是否可达边界
    private boolean DFS(char[][] board, boolean[][] vis, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) return true;
        if (board[row][col] == 'X' || vis[row][col]) return false;
        vis[row][col] = true;
        System.out.println("ok");
        boolean flag = false;
        for (int[] d : direction) {
            int newRow = row + d[0], newCol = col + d[1];
            //System.out.println(newRow + " " + newCol);
            boolean temp = DFS(board, vis, newRow, newCol);
            flag = flag || temp;
        }
        return flag;
    }

    //二次遍历，填充
    private void DFS2(char[][] board, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] == 'X') return;
        board[row][col] = 'X';
        for (int[] d : direction) {
            int newRow = row + d[0], newCol = col + d[1];
            DFS2(board, newRow, newCol);
        }
    }

    public static void main(String[] args) {
        char[][] chars = {{'O', 'O', 'O', 'O', 'X', 'X'}, {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'}, {'O', 'X', 'O', 'O', 'O', 'O'}};
        Leetcode130 leetcode130 = new Leetcode130();
        leetcode130.solve(chars);
    }

}
