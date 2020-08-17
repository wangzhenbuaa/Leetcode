public class Leetcode200 {
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int m, n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += DFS(grid, i, j);
            }
        }
        return ans;
    }

    public int DFS(char[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0') {
            return 0;
        }
        grid[row][col] = '0';
        for (int[] d : direction) {
            int newR = row + d[0], newC = col + d[1];
            DFS(grid, newR, newC);
        }
        return 1;
    }
}
