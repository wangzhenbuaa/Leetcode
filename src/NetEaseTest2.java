import java.util.Scanner;

public class NetEaseTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        boolean[] vis = new boolean[n + 1];
        int[] nums = new int[m];
        int[] finalNums = new int[n];
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            nums[i] = num;
            vis[num] = true;
        }
        int idx0 = 0, idx1 = 0;
        for (int i = 1; i <= n; i++) {
            if (idx0 < m) {
                if (i < nums[idx0]) {//i小于原始序列头
                    if (vis[i] == false) {
                        finalNums[idx1++] = i;
                    }
                } else {//i大于等于原始序列头
                    while (idx0 < m && i >= nums[idx0]) {
                        finalNums[idx1++] = nums[idx0++];
                    }
                }
            } else {//原始序列遍历完
                if (vis[i] == false) {
                    finalNums[idx1++] = i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(finalNums[i]);
        }
    }
}
