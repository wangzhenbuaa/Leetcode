public class leetcode647 {
    public static int countSubstrings(String s) {
        int ans = 0;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                if (isPalindrome(s.substring(i, i + len))) ans++;
            }
        }
        return ans;
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

}
