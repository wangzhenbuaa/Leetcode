public class leetcode647n {
    int cnt = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            countSubPalindrome(s, i, i);//统计奇数时
            countSubPalindrome(s, i, i + 1);//统计偶数时
        }
        return cnt;
    }

    //从字符串某一位开始扩展字符串来统计回文子串数
    void countSubPalindrome(String s, int st, int ed) {
        while (st >= 0 && ed < s.length() && s.charAt(st) == s.charAt(ed)) {
            st--;
            ed++;
            cnt++;
        }
    }
}
