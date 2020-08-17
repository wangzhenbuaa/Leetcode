public class leetcode572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        if (s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
        return false;
    }
}
