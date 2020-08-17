import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            res.add(sum / cnt);
        }
        return res;
    }
}
