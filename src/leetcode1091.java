import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        if (grid[0][0] != 0) return -1;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grid.length, n = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> temp = queue.poll();
                int row = temp.getKey(), col = temp.getValue();
                if (grid[row][col] == 1) continue;
                if (row == m - 1 && col == n - 1) return pathLength;
                grid[row][col] = 1;
                for (int[] step : direction) {
                    int newR = row + step[0], newC = col + step[1];
                    if (newR < 0 || newR >= m || newC < 0 || newC >= n) continue;
                    queue.add(new Pair<>(newR, newC));
                }
            }
        }
        return -1;
    }
}
