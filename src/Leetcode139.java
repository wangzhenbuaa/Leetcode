import java.util.List;
//超时了
public class Leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        boolean ans = false;
        for (String word : wordDict) {
            if (s.length() < word.length()) continue;
            if (word.equals(s.substring(0, word.length()))) {
                ans = ans || wordBreak(s.substring(word.length()), wordDict);
            }
        }
        return ans;
    }
}
