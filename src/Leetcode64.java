public class Leetcode64 {
    //  dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j]
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[j] = dp[j];//从上面走
                else if (i == 0) dp[j] = dp[j - 1];//从左边走
                else dp[j] = Math.min(dp[j], dp[j - 1]);
                dp[j] += grid[i][j];
            }
        }
        return dp[n - 1];
    }
}
