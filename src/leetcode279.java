public class leetcode279 {
    int minCnt = 1 << 30;

    public int numSquares(int n) {
        DFS(n,1);
        return minCnt;
    }

    private void DFS(int n, int cnt) {
        if (cnt > minCnt) return;
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt == n) {//递归边界
            minCnt = Math.min(cnt, minCnt);
        }
        for (int i = sqrt; i >= 1; i--) {
            DFS(n - i * i, cnt + 1);
        }
    }

    public static void main(String[] args) {
        leetcode279 leet = new leetcode279();
        System.out.println(leet.numSquares(13));
    }

}
