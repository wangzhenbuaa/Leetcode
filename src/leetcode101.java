public class leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isInverseTree(root.left, root.right);
    }

    public boolean isInverseTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val == t.val) {
            return isInverseTree(s.left, t.right) && isInverseTree(s.right, t.left);
        }
        return false;
    }
}
