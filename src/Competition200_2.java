import java.util.ArrayList;
import java.util.List;

public class Competition200_2 {
    public int getWinner(int[] arr, int k) {
        if (k >= arr.length) {
            int maxNum = arr[0];
            for (int i = 0; i < arr.length; i++) {
                maxNum = Math.max(maxNum, arr[i]);
            }
            return maxNum;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nums.add(arr[i]);
        }
        int cnt = 0;
        while (true) {
            while (nums.get(0) > nums.get(1)) {
                cnt++;
                if (cnt >= k) return nums.get(0);
                int temp = nums.get(1);
                nums.remove(1);
                nums.add(temp);
            }
            int temp = nums.get(0);
            nums.remove(0);
            nums.add(temp);
            cnt = 1;
            if (cnt >= k) return nums.get(0);
        }
    }
}
