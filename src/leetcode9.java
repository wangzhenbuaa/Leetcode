public class leetcode9 {
    public boolean isPalindrome(int x) {
        Integer it = x;
        String str = it.toString();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return true;
    }
}
