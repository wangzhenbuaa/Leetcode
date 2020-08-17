public class leetcode538 {
    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        update(root);
        return root;
    }

    public void update(TreeNode root) {
        if (root == null) return;
        update(root.right);
        root.val += sum;
        sum = root.val;
        update(root.left);
    }
}
