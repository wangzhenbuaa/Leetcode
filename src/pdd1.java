import java.util.ArrayList;
import java.util.List;

public class pdd1 {
    static List<Integer> findNum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int low = 0, high = nums.length - 1;
        int mid = low + (high - low) / 2;
        if (nums.length % 2 == 0) {//数组长度为偶数时
            if (nums[mid] != nums[mid + 1]) {//若两位中位数不相等时
                if (nums[0] == nums[mid]) res.add(nums[mid]);
                if (nums[nums.length - 1] == nums[mid + 1]) res.add(nums[mid + 1]);
                return res;
            }
        }
        int ans = nums[mid];
        high = mid;
        while (low < high) {//找到ans的最左位置
            mid = (low + high) / 2;
            if (nums[mid] < ans) low = mid + 1;
            else high = mid;
        }
        if (nums[low + (nums.length + 1) / 2 - 1] == ans) res.add(ans);
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        List<Integer> res = findNum(nums);
        System.out.println(res);
    }
}

/*
1,1,2,2,2,3
1,1,2,2
1,1,2,2,3
*
* */