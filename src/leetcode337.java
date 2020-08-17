public class leetcode337 {
    public int rob(TreeNode root) {
        return Math.max(robWithRoot(root), robWithoutRoot(root));
    }

    //偷根节点
    public int robWithRoot(TreeNode root) {
        if (root == null) return 0;
        return robWithoutRoot(root.left) + robWithoutRoot(root.right) + root.val;
    }

    //不偷根节点
    public int robWithoutRoot(TreeNode root) {
        if (root == null) return 0;
        return rob(root.left) + rob(root.right);
    }
}
