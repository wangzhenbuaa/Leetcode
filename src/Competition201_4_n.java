import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//区间dp
public class Competition201_4_n {
    //切分木棍转化为合并木棍需要总成本最小
    public static int minCost(int n, int[] cuts) {
        List<Integer> list = new ArrayList<>();//存储小木棍端点
        list.add(0);
        list.add(n);
        for (int st : cuts) {
            list.add(st);
        }
        Collections.sort(list);
        int[][] dp = new int[list.size()][list.size()];
        //num 端点数
        for (int num = 2; num <= cuts.length + 1; num++) {
            for (int i = 0; i + num < list.size(); i++) {
                dp[i][i + num] = 1 << 30;
                for (int k = i + 1; k < i + num; k++) {
                    int mid = list.get(k);
                    dp[i][i + num] = Math.min(dp[i][i + num], dp[i][k] + dp[k][i + num] + list.get(i + num) - list.get(i));
                }
            }
        }
        return dp[0][list.size()-1];
    }

    public static void main(String[] args) {
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};
        System.out.println(minCost(n, cuts));
    }
}
