public class Leetcode474 {
    private int countZeros(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') cnt++;
        }
        return cnt;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int num1 = countZeros(str), num2 = str.length() - num1;
            for (int i = m; i >= num1; i--) {
                for (int j = n; j >= num2; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - num1][j - num2] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
