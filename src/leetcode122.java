public class leetcode122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int st = prices[0], ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += prices[i] > st ? prices[i] - st : 0;
            st = prices[i];
        }
        return ans;
    }
}
