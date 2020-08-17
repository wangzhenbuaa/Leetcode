import java.util.ArrayList;
import java.util.List;

public class leetcode653 {
    List<Integer> valList = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        int left = 0, right = valList.size() - 1;
        while (left < right) {
            int sum = valList.get(left) + valList.get(right);
            if (sum == k) return true;
            else if (sum < k) left++;
            else right--;
        }
        return false;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        valList.add(root.val);
        inOrder(root.right);
    }
}
