public class Leetcode62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) dp[j] = dp[j]; //从上面走
                else if (i == 0) dp[j] = dp[j - 1]; //从左边走
                else dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
