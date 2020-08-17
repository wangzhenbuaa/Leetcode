import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode378n {
    private class Tuple {
        int row, col, val;

        public Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.val - o2.val;
            }
        });
        //初始化堆
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 1; i < k; i++) {
            Tuple temp = pq.poll();
            if (temp.row == m - 1) continue;
            pq.offer(new Tuple(temp.row + 1, temp.col, matrix[temp.row + 1][temp.col]));
        }
        return pq.poll().val;
    }

}
