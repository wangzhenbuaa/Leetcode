import java.util.ArrayList;
import java.util.List;

public class leetcode530 {
    List<Integer> valList = new ArrayList<>();
    int ans = 1 << 30;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        for (int i = 0; i < valList.size() - 1; i++) {
            ans = Math.min(ans, valList.get(i + 1) - valList.get(i));
        }
        return ans;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        valList.add(root.val);
        inOrder(root.right);
    }
}
