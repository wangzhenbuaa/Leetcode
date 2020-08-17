import java.util.Scanner;

public class NetEaseTest3 {

    static boolean isOk(int[] nums, int sum) {
        if (sum < 0) return false;
        if (sum == 0) return true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int temp = nums[i];
            nums[i] = 0;
            isOk(nums, sum - temp);
            nums[i] = temp;
        }
        return false;
    }

    static int solution(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int ans = sum / 2;
        while (ans > 0) {
            if (isOk(nums, ans)) {
                if (isOk(nums, ans)) {
                    System.out.println(ans);
                    return sum - 2 * ans;
                }
            }
            ans--;
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(solution(nums));
        }
    }
}

/*
1
5
5 15 30 30 60


* */