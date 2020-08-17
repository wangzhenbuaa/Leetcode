import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode501 {
    int pre = 1 << 30, maxNum = 0, num = 0;
    Set<Integer> res = new HashSet<>();

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] ans = new int[res.size()];
        int idx=0;
        for(int r:res){
            ans[idx++]=r;
        }
        return ans;
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        num = root.val == pre ? num + 1 : 1;
        pre = root.val;
        if (num > maxNum) {
            res.clear();
            res.add(root.val);
            maxNum=num;
        } else if (num == maxNum) {
            res.add(root.val);
        }
        inOrder(root.right);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        // 使用泛型，无需显式类型转换
        String[] array = list.toArray(new String[list.size()]);

        System.out.println(array[0]);
    }
}
