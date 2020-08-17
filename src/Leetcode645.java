public class Leetcode645 {
    public int[] findErrorNums(int[] nums) {
        byte[] cnt = new byte[nums.length + 1];
        int a = -1, b = -1;
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (cnt[i] == 2) a = i;
            if (cnt[i] == 0) b = i;
        }
        return new int[]{a, b};
    }
}
