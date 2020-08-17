public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int low = 0, high = nums.length - 1;
        int left = -1, right = -1;
        //寻找最左边的target
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else high = mid;
        }
        if (nums[low] == target) left = low;
        else return new int[]{left, right};
        //寻找最右边的target
        low = left;
        high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) high = mid - 1;
            else low = mid;
        }
        right = nums[high] == target ? high : low;
        return new int[]{left, right};
    }
}
