public class Leetcode279_dp {
    //递归反向遍历；动规正向遍历
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sqr = (int) Math.sqrt(i);
            if (sqr * sqr == i) dp[i] = 1;
            else {
                dp[i] = i;//最大为n了
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
