import java.util.ArrayList;
import java.util.List;

public class leetcode230 {
    public List<Integer> valList = new ArrayList();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return valList.get(k - 1);
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        valList.add(root.val);
        inOrder(root.right);
    }

}
