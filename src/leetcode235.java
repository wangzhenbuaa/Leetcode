public class leetcode235 {
    //该种解法不仅仅适用于BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!(isSubTreeNode(root, p) && isSubTreeNode(root, q))) return null;
        if (isSubTreeNode(root.left, p) && isSubTreeNode(root.left, q)) return lowestCommonAncestor(root.left, p, q);
        if (isSubTreeNode(root.right, p) && isSubTreeNode(root.right, q)) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    //是否为子节点
    public boolean isSubTreeNode(TreeNode root, TreeNode sub) {
        if (root == null) return false;
        if (root == sub) return true;
        return isSubTreeNode(root.left, sub) || isSubTreeNode(root.right, sub);
    }
}
