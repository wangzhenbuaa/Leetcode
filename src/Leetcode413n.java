public class Leetcode413n {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int[] dp = new int[A.length];//dp[i]以A[i]结尾的等差数列数组数
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int cnt : dp) {
            ans += cnt;
        }
        return ans;
    }
}
