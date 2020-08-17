public class Leetcode695 {
    private int m, n;//先设全局变量，再在方法中赋值
    private int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, DFS(grid, i, j));
            }
        }
        return maxArea;
    }

    public int DFS(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) {
            return 0;
        }
        int ans = 1;
        grid[row][col] = 0;//遍历过就标记为0
        for (int[] d : direction) {
            int newRow = row + d[0], newCol = col + d[1];
            ans += DFS(grid, newRow, newCol);
        }
        return ans;
    }

}
