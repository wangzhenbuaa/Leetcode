public class leetcode409 {
    public int longestPalindrome(String s) {
        if (s == null) return 0;
        int[] charNum = new int[128];
        for (char c : s.toCharArray()) {
            charNum[c]++;
        }
        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < 128; i++) {
            if (charNum[i] % 2 == 0) {
                ans += charNum[i];
            } else {
                ans += charNum[i] - 1;
                flag = true;
            }
        }
        return flag == true ? ans + 1 : ans;
    }
}
