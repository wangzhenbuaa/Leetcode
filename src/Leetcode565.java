public class Leetcode565 {
    public int arrayNesting(int[] nums) {
        int maxCnt = 0;
        for (int num : nums) {
            boolean[] vis = new boolean[nums.length];
            int idx = num;
            int cnt = 0;
            while (vis[idx] == false) {
                vis[idx] = true;
                cnt++;
                idx = nums[idx];
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        return maxCnt;
    }
}
