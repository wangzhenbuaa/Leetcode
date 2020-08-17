public class Leetcode494 {
    int ans = 0;
    int S;

    private void findTargetSum(int[] nums, int idx, int sum) {
        if (idx == nums.length) {
            if (sum == S) ans++;
            return;
        }
        findTargetSum(nums, idx + 1, sum + nums[idx]);
        findTargetSum(nums, idx + 1, sum - nums[idx]);
    }

    public int findTargetSumWays(int[] nums, int S) {
        this.S = S;
        findTargetSum(nums, 0, 0);
        return ans;
    }
}
