import java.util.ArrayList;
import java.util.List;

public class Leetcode279_dp2 {
    //递归反向遍历；动规正向遍历
    private static List<Integer> generateSquareNums(int n) {
        List<Integer> squares = new ArrayList<>();
        int sqr = (int) Math.sqrt(n);
        for (int i = 1; i <= sqr; i++) {
            squares.add(i * i);
        }
        return squares;
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        List<Integer> squares = generateSquareNums(n);
        dp[1] = 1;
        dp[n] = n;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int square : squares) {
                if (square > i) break;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
