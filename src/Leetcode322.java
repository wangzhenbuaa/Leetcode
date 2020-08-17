import java.util.Arrays;

public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        final int INF = 1 << 30;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == INF ? -1 : dp[amount];
    }
}
