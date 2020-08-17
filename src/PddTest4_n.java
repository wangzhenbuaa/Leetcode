import java.util.Scanner;

public class PddTest4_n {
    static final int mod = 1000000009;
    static char[][] graph;

    private static boolean checkLeft(int row, int col) {//左边是否安全
        if (col - 1 < 0) return true;
        if (graph[row][col - 1] == '*') return true;
        return false;
    }

    private static boolean checkUp(int row, int col) {//上边是否安全
        if (row - 1 < 0) return true;
        if (graph[row - 1][col] == '*') return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] dp = new int[n][n];
        graph = new char[n][n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == '#') {
                    if (!checkLeft(i, j) && !checkUp(i, j)) {
                        dp[i][j] = dp[i - 1][i] * dp[i][i - 1] * 4 + dp[i - 1][i - 1] * 5 * 5;
                    }
                    else if(!checkLeft(i, j)||!checkUp(i,j)){
                        dp[i][j] = dp[i][j-1]*dp[i-1][j]*5;
                    }
                    else {
                        dp[i][j] = dp[i][j-1]*dp[i-1][j]*6;
                    }
                }
                else {
                }
            }
        }
    }
}
