public class leetcode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sumOfLeftLeavesStartRoot(root) + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeavesStartRoot(TreeNode root) {
        if (root == null) return 0;
        //符合左叶结点条件
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val;
        }
        return 0;
    }
}
