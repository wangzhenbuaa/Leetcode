public class leetcode242 {
    //是否是字母异位词
    public boolean isAnagram(String s, String t) {
        int[] charNum = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            charNum[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charNum[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charNum[i] > 0) return false;
        }
        return true;
    }
}
