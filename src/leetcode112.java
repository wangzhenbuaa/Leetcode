public class leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //root为根节点
        if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {//root不为根节点
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
