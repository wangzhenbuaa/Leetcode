public class Leetcode440 {
    //以st为根节点的前缀树结点数
    private static int findNums(long st, long ed, int n) {
        int cnt = 0;
        while (st <= n) {
            cnt += Math.min(n + 1, ed) - st;
            st *= 10;
            ed *= 10;//用int此处可能越界
        }
        return cnt;
    }

    public static int findKthNumber(int n, int k) {
        k--;//第一个结点是1
        int cur = 1;
        while (k > 0) {
            int num = findNums(cur, cur + 1, n);
            if (k - num >= 0) {//第k个数不在以cur为根节点的树上
                k -= num;
                cur++;//字典树根节点往左移
            } else {//在子树中
                k--;//减去根节点
                cur *= 10;//根节点往下移
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(findKthNumber(13,2));
    }
}
