import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Competition201_3 {
    public static int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Boolean> map = new HashMap<>();
        int ans = 0;
        int[] sums = new int[nums.length];
        map.put(0, true);
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i] + (i == 0 ? 0 : sums[i - 1]);
            if (map.get(sums[i] - target)!=null) {
                ans++;
                map.clear();
                map.put(0, true);
                sums[i] = 0;
            } else {
                map.put(sums[i], true);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 3, 5, 1, 4, 2, -9};
        int target = 6;
        System.out.println(maxNonOverlapping(nums, target));
    }
}
