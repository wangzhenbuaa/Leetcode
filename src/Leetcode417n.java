import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode417n {
    int m, n;
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] matrix;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canreachP = new boolean[m][n];
        boolean[][] canreachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            DFS(i, 0, canreachP);
            DFS(i, n - 1, canreachA);
        }
        for (int j = 0; j < n; j++) {
            DFS(0, j, canreachP);
            DFS(m - 1, j, canreachA);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canreachP[i][j] && canreachA[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void DFS(int r, int c, boolean[][] vis) {
        vis[r][c] = true;
        for (int[] d : direction) {
            int nextR = r + d[0], nextC = c + d[1];
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || vis[nextR][nextC] || matrix[nextR][nextC] < matrix[r][c])
                continue;
            DFS(nextR, nextC, vis);
        }
    }
}
