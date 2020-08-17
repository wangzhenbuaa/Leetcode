import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Leetcode413 {

    //判断是否为等差数列
    private boolean judge(int[] nums, int st, int ed) {
        if (ed - st < 2) return false;
        int temp = nums[st + 1] - nums[st];
        for (int i = st + 2; i <= ed; i++) {
            if (nums[i] - nums[i - 1] != temp) return false;
        }
        return true;
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int[] dp = new int[A.length];//dp[i] 字符串A[0]-A[i]的等差数组个数
        int start = 0;//记录前一个最长等差数组的起点
        int idx = 2;
        dp[1] = 0;
        while (idx < A.length) {
            while (idx < A.length && !judge(A, idx - 2, idx)) {
                dp[idx] = dp[idx - 1];
                idx++;
            }
            if (idx == A.length) return dp[idx - 1];
            start = idx - 2;
            int temp = A[start + 1] - A[start];
            while (idx < A.length && A[idx] - A[idx - 1] == temp) {
                dp[idx] = dp[idx - 1] + idx - start - 1;//dp[idx-1]加上以idx结尾的等差数组数
                idx++;
            }
        }
        return dp[idx - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Leetcode413 leetcode413 = new Leetcode413();
        int ans = leetcode413.numberOfArithmeticSlices(nums);
        System.out.println(ans);
    }
}

