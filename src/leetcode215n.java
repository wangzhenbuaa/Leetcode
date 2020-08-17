import javafx.util.Pair;

public class leetcode215n {
    public int findKthLargest(int[] nums, int k) {
        int objectPos = nums.length - k;
        int left = 0, right = nums.length - 1, pos = -1;
        while (left < right) {
            pos = Partition(nums, left, right);
            if (pos == objectPos) break;
            else if (pos < objectPos) left = pos + 1;
            else if (pos > objectPos) right = pos - 1;
        }
        return nums[pos];
    }

    public int Partition(int[] nums, int left, int right) {
        int a = nums[left];
        while (left < right) {
            while (nums[right] > a && left < right) right--;
            nums[left] = nums[right];
            while (nums[left] <= a && left < right) left++;
            nums[right] = nums[left];
        }
        nums[left] = a;
        return left;
    }
}
