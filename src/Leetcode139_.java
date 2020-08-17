import java.util.List;

public class Leetcode139_ {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i - len >= 0 && s.substring(i - len, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[s.length()];
    }
}
