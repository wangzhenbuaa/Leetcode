public class leetcode543 {
    public int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left), right = depth(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}
