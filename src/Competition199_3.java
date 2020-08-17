import java.util.ArrayList;
import java.util.List;

public class Competition199_3 {
    int distance;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        if (root == null) return 0;
        int ans = 0;   //以root为根节点，其左右子树的叶结点所能配对的对数
        List<Integer> dis1 = calLeafDis(root.left);
        List<Integer> dis2 = calLeafDis(root.right);
        for (int i : dis1) {
            for (int j : dis2) {
                if (i + j + 2 <= distance) ans++;
            }
        }
        return countPairs(root.left, distance) + countPairs(root.right, distance) + ans;
    }

    private List<Integer> calLeafDis(TreeNode root) {
        List<Integer> dis = new ArrayList<>();
        if (root == null) return dis;
        if (root.left == null && root.right == null) {
            dis.add(0);
            return dis;
        }
        List<Integer> dis1 = calLeafDis(root.left);
        List<Integer> dis2 = calLeafDis(root.right);
        for (int i : dis1) {
            if (i + 1 <= distance) dis.add(i + 1);
        }
        for (int i : dis2) {
            if (i + 1 <= distance) dis.add(i + 1);
        }
        return dis;
    }

}
