import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode417 {
    int m, n;
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] pacific, atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfsP(matrix, i, 0);
            dfsA(matrix, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfsP(matrix, 0, j);
            dfsA(matrix, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfsP(int[][] matrix, int r, int c) {
        pacific[r][c] = true;
        for (int[] d : direction) {
            int newR = r + d[0], newC = c + d[1];
            if (newR < 0 || newR >= m || newC < 0 || newC >= n || pacific[newR][newC]) continue;
            if (matrix[newR][newC] < matrix[r][c]) continue;
            dfsP(matrix, newR, newC);
        }
    }

    private void dfsA(int[][] matrix, int r, int c) {
        atlantic[r][c] = true;
        for (int[] d : direction) {
            int newR = r + d[0], newC = c + d[1];
            if (newR < 0 || newR >= m || newC < 0 || newC >= n || atlantic[newR][newC]) continue;
            if (matrix[newR][newC] < matrix[r][c]) continue;
            dfsA(matrix, newR, newC);
        }
    }
}
