public class leetcode540 {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int leftNum = mid - low, rightNum = high - mid;//mid左侧的数个数，mid右侧的数个数
            if (nums[mid] == nums[mid + 1]) rightNum--;
            else if (nums[mid] == nums[mid - 1]) leftNum--;
            else return nums[mid];
            if (leftNum % 2 == 1) high = low + leftNum - 1;//单一元素在左侧
            else low = high - rightNum + 1;//单一元素在右侧
        }
        return nums[low];
    }
}
