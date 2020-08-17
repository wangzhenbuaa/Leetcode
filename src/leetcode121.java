public class leetcode121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0], ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }
}
