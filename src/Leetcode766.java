public class Leetcode766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return true;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j - i >= 0) {
                    if (matrix[i][j] != matrix[0][j - i]) return false;
                } else {
                    if (matrix[i][j] != matrix[i - j][0]) return false;
                }
            }
        }
        return true;
    }
}
