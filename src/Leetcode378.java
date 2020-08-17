public class Leetcode378 {
    //N=m*n
    //二分解法 O(N*log(N))
    //排序解法 O(N*log(N)*N)
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            //判断mid小于k-Element还是大于k-Element
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
