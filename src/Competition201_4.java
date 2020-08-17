import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Competition201_4 {
    static Map<Pair<Integer, int[]>, Integer> results = new HashMap<>();

    public static int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        if (cuts.length == 1) return n;
        int ans = 1 << 30;
        for (int i = 0; i < cuts.length; i++) {
            int temp = 0;
            if (i > 0) {
                int[] leftCuts = new int[i];
                for (int j = 0; j < leftCuts.length; j++) {
                    leftCuts[j] = cuts[j];
                }
                if (results.get(new Pair<>(cuts[i], leftCuts)) == null) {
                    results.put(new Pair<>(cuts[i], leftCuts), minCost(cuts[i], leftCuts));
                }
                temp += results.get(new Pair<>(cuts[i], leftCuts));
            }
            if (i < cuts.length - 1) {
                int[] rightCuts = new int[cuts.length - i - 1];
                for (int j = 0; j < rightCuts.length; j++) {
                    rightCuts[j] = cuts[i + j + 1] - cuts[i];
                }
                if (results.get(new Pair<>(n - cuts[i], rightCuts)) == null) {
                    results.put(new Pair<>(n - cuts[i], rightCuts), minCost(n - cuts[i], rightCuts));
                }
                temp += results.get(new Pair<>(n - cuts[i], rightCuts));
            }
            ans = Math.min(ans, temp);
        }
        return ans + n;
    }

    public static void main(String[] args) {
        int n = 9;
        int[] cuts = {5, 6, 1, 4, 2};
        System.out.println(minCost(n, cuts));
    }

    /*
10
1,4,6,7,8
26

7
[1,3,4,5]
16

9
[5,6,1,4,2]
22

5
[3,1,4]
10

20
1,14,18,6,17,8,10,4,13,16,7
71

30
18,15,13,7,5,26,25,29
92
    * */
}
