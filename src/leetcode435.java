import java.util.Arrays;
import java.util.Comparator;

// 去除重叠区间
public class leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        int right = intervals[0][1];
        int num = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (right <= intervals[i][0]) {
                num++;
                right = intervals[i][1];
            }
        }
        return intervals.length - num;
    }
}
