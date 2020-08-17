import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Competition200_3 {
    public static int minSwaps(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int n = grid.length;
        List<Integer> nums = new ArrayList<>();
        int[] tempNums = new int[n];
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) continue;
                tempNums[i] = j;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            nums.add(tempNums[i]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) > i) {
                int j = i + 1;
                for (; j < n; j++) {
                    if (nums.get(j) <= i) {
                        cnt += (j - i);
                        int temp = nums.get(j);
                        nums.remove(j);
                        nums.add(i, temp);
                        break;
                    }
                }
                if (j == n) return -1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
