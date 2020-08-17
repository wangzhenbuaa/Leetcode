public class leetcode671n {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return -1;
        //因为题目限制了不存在单支子树的情况
        int leftVal = root.left.val, rightVal = root.right.val;
        if (leftVal == root.val) {
            leftVal = findSecondMinimumValue(root.left);
        }
        if (rightVal == root.val) {
            rightVal = findSecondMinimumValue(root.right);
        }
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        if (leftVal != -1) return leftVal;
        return rightVal;
    }
}
