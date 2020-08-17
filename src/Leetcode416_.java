public class Leetcode416_ {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        //转化为求背包容量为W是否能刚好填满的问题
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }
}
