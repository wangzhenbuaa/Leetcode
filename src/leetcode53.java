public class leetcode53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] s = new int[nums.length];//s[i]以nums[i]结尾的最大连续子序列和
        s[0] = nums[0];
        int ans = s[0];
        for (int i = 1; i < nums.length; i++) {
            s[i] = Math.max(0, s[i - 1]) + nums[i];
            ans = Math.max(ans, s[i]);
        }
        return ans;
    }
}