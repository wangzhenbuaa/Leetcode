import java.util.Arrays;

public class leetcode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {//若胃口g[gi]被满足了
                gi++;
            }
            si++;
        }
        return gi;
    }
}
