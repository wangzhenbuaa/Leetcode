public class leetcode69 {
    public int mySqrt(int x) {
        int l = 0, h = x;
        while (l < h) {
            int m = l + (h - l) / 2;
            int ans = m * m;
            if (ans == x) return m;
            else if (ans < x) l = m;
            else h = m - 1;
        }
        return l;
    }
}
