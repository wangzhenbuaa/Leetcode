public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < nums.length) {
            if (nums[idx1] != 0) {
                nums[idx2++] = nums[idx1];
            }
            idx1++;
        }
        while (idx2 < nums.length) {
            nums[idx2++] = 0;
        }
    }
}
