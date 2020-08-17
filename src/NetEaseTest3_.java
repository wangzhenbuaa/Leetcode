import java.util.Scanner;

public class NetEaseTest3_ {
    static int minRemain;
    static int sum;

    private static void solution(int[] nums, int idx, int ans1, int ans2) {
        if (idx == nums.length) {
            if (ans1 == ans2) {
                minRemain = Math.min(minRemain, sum - ans1 - ans2);
            }
            return;
        }
        int val = nums[idx];
        solution(nums, idx + 1, ans1 + val, ans2);//加给1
        solution(nums, idx + 1, ans1, ans2 + val);//加给2
        solution(nums, idx + 1, ans1, ans2);//都不加
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            sum = 0;
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
                sum += nums[j];
            }
            minRemain = sum;
            solution(nums, 0, 0, 0);
            System.out.println(minRemain);
        }
    }
}

/*
1
5
5 15 30 30 60


* */