import java.util.Scanner;

public class leetcode665 {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return checkIncreasing(nums, i) || checkIncreasing(nums, i + 1);
            }
        }
        return true;
    }

    public boolean checkIncreasing(int[] nums, int pos) {
        int pre = pos == 0 ? nums[1] : nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            if (idx == pos) continue;
            if (pre > nums[idx]) return false;
            pre = nums[idx];
        }
        return true;
    }
}
