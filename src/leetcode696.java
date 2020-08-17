public class leetcode696 {
    private int cnt;

    public int countBinarySubstrings(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) continue;
            cnt++;
            countSubstrings(s, i, i + 1);
        }
        return cnt;
    }

    private void countSubstrings(String s, int stL, int stR) {
        int left = stL - 1, right = stR + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(stL) && s.charAt(right) == s.charAt(stR)) {
            cnt++;
            left--;
            right++;
        }
    }
}
