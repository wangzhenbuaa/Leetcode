public class leetcode111 {
    public int ans = 1 << 30;

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        calcuDepth(root, 1);
        return ans;
    }

    public void calcuDepth(TreeNode root, int depth) {
        if(root.left==null&&root.right==null){
            ans = Math.min(ans, depth);
            return;
        }
        if(root.left!=null){
            calcuDepth(root.left, depth + 1);
        }
        if(root.right!=null){
            calcuDepth(root.right, depth + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(1<<30);
    }
}
