public class leetcode437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    //带根节点的路径
    public int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == sum) {
            ret++;
        }
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
}
