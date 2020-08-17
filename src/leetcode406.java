import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
            }
        });
        List<int[]> queue = new ArrayList<>();
        for(int[] p : people){
            queue.add(p[1],p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

}
