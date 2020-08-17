public class Leetcode70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        //此处动态规划与递归的区别是，后者要多次计算某个子部分，如climbStairs(n-3)
        //return climbStairs(n - 2) + climbStairs(n - 1);
        int pre1 = 1, pre2 = 2;
        for (int i = 2; i <= n; i++) {
            int temp = pre2;
            pre2 += pre1;
            pre1 = temp;
        }
        return pre1;
    }
}
