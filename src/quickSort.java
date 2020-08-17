public class quickSort {
    //对区间[left,right]进行划分
    public static int partition(int[] nums, int left, int right) {
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

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pos = partition(nums, left, right);
        sort(nums, left, pos - 1);
        sort(nums, pos + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 2, 1, 3};
        sort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
