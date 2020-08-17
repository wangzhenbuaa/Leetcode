public class Competition199_2 {
    public int minFlips(String target) {
        if (target == null) return 0;
        int idx = 0;//找到第一个1的位置
        while (idx < target.length() && target.charAt(idx) == '0') {
            idx++;
        }
        //target中没有1
        if (idx == target.length()) return 0;
        char pre = target.charAt(idx);
        int ans = 1;
        for (int i = idx + 1; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (ch != pre) {
                ans++;
                pre = ch;
            }
        }
        return ans;
    }
}
