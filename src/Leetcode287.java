public class Leetcode287 {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        //找到相遇点
        while (slow != fast) {
            slow = nums[slow];//slow走一步
            fast = nums[fast];//fast走两步
            fast = nums[fast];
        }
        //从相遇点开始，两者走相同的步数，相遇时即为环入口
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
