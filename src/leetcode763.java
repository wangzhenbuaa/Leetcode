import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//区间合并问题变形
public class leetcode763 {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        //区间记录下标所对应的字符在字符串中第一次和最后一次出现时的索引位置
        int[][] interval = new int[26][2];
        //初始化
        for (int i = 0; i < 26; i++) {
            interval[i][0] = -1;
            interval[i][1] = -1;
        }
        //计算区间起点和终点
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (interval[ch - 'a'][0] == -1) interval[ch - 'a'][0] = i;
            interval[ch - 'a'][1] = i;
        }
        Arrays.sort(interval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < 26; i++) {
            System.out.println(interval[i][0] + " " + interval[i][1]);
        }
        int st = 0;
        for (int i = 0; i < 26; i++) {
            if (interval[i][0] == -1) continue;
            st = i;
            break;
        }
        int left = interval[st][0], right = interval[st][1];
        for (int i = st + 1; i < 26; i++) {
            if (interval[i][0] > right) {
                res.add(right - left + 1);
                left = interval[i][0];
            }
            right = Math.max(right, interval[i][1]);
        }
        res.add(right - left + 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("abac"));
    }
}
