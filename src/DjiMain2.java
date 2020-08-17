import java.util.Scanner;

public class DjiMain2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), c = sc.nextInt();
        int[] w = new int[n];
        int[] cost = new int[n];
        int[] dp = new int[c + 1];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = c; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + w[i]);
            }
        }
        System.out.println(dp[c]);
    }
}
