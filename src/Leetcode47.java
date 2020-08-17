import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode47 {
    HashSet<List<Integer>> res = new HashSet<>();
    List<Integer> path = new ArrayList<>();
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        vis = new boolean[nums.length];
        backtrack(nums, 0);
        for (List<Integer> el : res) {
            ans.add(el);
        }
        return ans;
    }

    private void backtrack(int[] nums, int k) {
        if (k == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == false) {
                vis[i] = true;
                path.add(nums[i]);
                backtrack(nums, k + 1);
                path.remove(path.size() - 1);
                vis[i] = false;
            }
        }
    }
}
