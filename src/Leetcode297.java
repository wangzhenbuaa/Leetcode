import java.util.LinkedList;
import java.util.Queue;

public class Leetcode297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            if (top == null) ans.append("null,");
            else {
                ans.append(top.val + ",");
                queue.offer(top.left);
                queue.offer(top.right);
            }
        }
        ans.deleteCharAt(ans.length() - 1);//删除最后一个逗号
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("null")) return null;
        System.out.println(data+"hah");
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;
        while (idx < vals.length) {
            TreeNode top = queue.poll();
            if (vals[idx].equals("null")) top.left = null;
            else {
                top.left = new TreeNode(Integer.parseInt(vals[idx]));
                queue.offer(top.left);
            }
            idx++;
            if (idx >= vals.length) break;
            if (vals[idx].equals("null")) top.right = null;
            else {
                top.right = new TreeNode(Integer.parseInt(vals[idx]));
                queue.offer(top.right);
            }
            idx++;
        }
        return root;
    }
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
