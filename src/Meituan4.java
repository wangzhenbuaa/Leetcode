import java.util.Scanner;

public class Meituan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt(), b = sc.nextInt();
        int[][] profit = new int[n][2];
        for (int i = 0; i < n; i++) {
            profit[i][0] = sc.nextInt();
            profit[i][1] = sc.nextInt();
        }
        int[][] dp = new int[a + 1][b + 1];
        for (int p = 0; p < n; p++) {
            for (int i = a; i >= 0; i--) {
                for (int j = b; j >= 0; j--) {
                    int temp1 = 0, temp2 = 0;
                    if (i >= 1) temp1 = dp[i - 1][j] + profit[p][0];
                    if (j >= 1) temp2 = dp[i][j - 1] + profit[p][1];
                    int temp = Math.max(temp1, temp2);
                    dp[i][j] = Math.max(temp, dp[i][j]);
                }
            }
        }
        System.out.println(dp[a][b]);
    }
}

/*
5 2 2
1 2
5 4
5 3
4 5
1 3

* */