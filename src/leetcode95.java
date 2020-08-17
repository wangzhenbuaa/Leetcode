import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//生成二叉搜索树
public class leetcode95 {
    public static List<TreeNode> createTrees(int st, int ed) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (st > ed) {
            res.add(null);
            return res;
        }
        for (int i = st; i <= ed; i++) {
            List<TreeNode> left = createTrees(st, i - 1);
            List<TreeNode> right = createTrees(i + 1, ed);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<TreeNode>();
        }
        return createTrees(1, n);
    }

}

