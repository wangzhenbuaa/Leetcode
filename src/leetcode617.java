//合并二叉树
public class leetcode617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t2 != null) {
            if (t1 == null) {
                t1 = new TreeNode(t2.val);
                t1.left = t2.left;
                t1.right = t2.right;
            } else {
                t1.val = t1.val + t2.val;
                t1.left = mergeTrees(t1.left, t2.left);
                t1.right = mergeTrees(t1.right, t2.right);
            }
        }
        return t1;
    }
}
