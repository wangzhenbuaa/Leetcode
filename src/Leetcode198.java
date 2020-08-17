public class Leetcode198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = temp;
        }
        return pre1;
    }
}
