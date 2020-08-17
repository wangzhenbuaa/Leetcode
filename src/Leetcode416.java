public class Leetcode416 {
    boolean res = false;

    private void canPartition(int[] nums, int idx, int ans1, int ans2) {
        if (idx == nums.length) {
            if (ans1 == ans2) res = true;
            return;
        }
        canPartition(nums, idx + 1, ans1 + nums[idx], ans2);
        canPartition(nums, idx + 1, ans1, ans2 + nums[idx]);
    }

    public boolean canPartition(int[] nums) {
        canPartition(nums, 0, 0, 0);
        return res;
    }
}
