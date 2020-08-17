public class leetcode205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        //记录一个字符上次出现的位置，若两个字符串中的字符上次出现的位置相同，那么久属于同构
        int[] preIndexOfs = new int[128];
        int[] preIndexOft = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (preIndexOfs[cs] != preIndexOft[ct]) return false;
            preIndexOfs[cs] = i + 1;
            preIndexOft[ct] = i + 1;
        }
        return true;
    }
}
