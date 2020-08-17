public class leetcode153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] > nums[mid]) right = mid;//旋转点在左侧
            else if (nums[mid] > nums[right]) left = mid;//旋转点在右侧
            else break;//不存在旋转点
        }
        return Math.min(nums[left], nums[right]);
    }
}
