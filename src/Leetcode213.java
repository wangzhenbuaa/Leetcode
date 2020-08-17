public class Leetcode213 {
    //[1,2,3,1]
    //Leetcode198的升级版
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre2 = 0, pre1 = nums[0];//with head
        int pre2WithoutHead = 0, pre1WithoutHead = 0;//without head
        for (int i = 1; i < nums.length - 1; i++) {
            int temp = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = temp;
            temp = Math.max(pre2WithoutHead + nums[i], pre1WithoutHead);
            pre2WithoutHead = pre1WithoutHead;
            pre1WithoutHead = temp;
        }
        return Math.max(pre1, pre2WithoutHead + nums[nums.length - 1]);
    }
}
