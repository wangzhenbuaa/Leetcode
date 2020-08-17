public class Leetcode485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0, maxAns = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = nums[i] == 1 ? ans + 1 : 0;
            maxAns = Math.max(maxAns, ans);
        }
        return maxAns;
    }
}
