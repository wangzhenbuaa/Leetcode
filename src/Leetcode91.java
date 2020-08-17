public class Leetcode91 {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (num == 10 || num == 20) dp[i] = (i - 2 >= 0 ? dp[i - 2] : 1);
            else if (num % 10 == 0) return 0;
            else if (num > 26 || num < 10) dp[i] = dp[i - 1];
            else dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("21"));
    }
}
