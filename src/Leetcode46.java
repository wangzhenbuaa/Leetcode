import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode46 {
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return paths;
        backtracking(nums, 0);
        return paths;
    }

    private void backtracking(int[] nums, int k) {
        if (k == nums.length) {
            //注意此处需要新建List，不能将path直接放入
            List<Integer> temp = new ArrayList<>(path);
            paths.add(temp);
            return;
        }
        for (int num : nums) {
            if (path.contains(num)) continue;
            path.add(num);
            backtracking(nums, k + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        Leetcode46 leetcode46 = new Leetcode46();
        System.out.println(leetcode46.permute(nums));
    }
}
