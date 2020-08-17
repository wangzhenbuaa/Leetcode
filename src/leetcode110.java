// 判断是否为平衡树
public class leetcode110 {
    public boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) {
            result = false;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
