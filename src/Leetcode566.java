public class Leetcode566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c || (m == r && n == c)) return nums;
        int[][] res = new int[r][c];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[idx / c][idx % c] = nums[i][j];
                idx++;
            }
        }
        return res;
    }
}
