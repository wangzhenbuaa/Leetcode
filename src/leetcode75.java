public class leetcode75 {
    public void sortColors(int[] nums) {
        int pos = 0, left = -1, right = nums.length;
        while (pos < right) {
            if (nums[pos] == 0) swap(nums, ++left, pos++); //pos左边的所有元素都为0或1，因此swap后pos可+1
            else if (nums[pos] == 2) swap(nums, --right, pos);//此处swap后无法保证换过来的元素为0或1，因此swap不自增
            else pos++;
        }
    }

    public void swap(int[] nums, int pos1, int pos2) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
