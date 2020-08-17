import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode257 {
    List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        backtracking(root, new StringBuilder());
        return paths;
    }

    private void backtracking(TreeNode root, StringBuilder path) {
        if (root == null) return;
        if (path.length() != 0) path.append("->");
        path.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(path.toString());
            //注意点2
            int idx = path.lastIndexOf("->");
            idx = idx == -1 ? 0 : idx;
            path.delete(idx, path.length());
            return;
        }
        backtracking(root.left, path);
        backtracking(root.right, path);
        int idx = path.lastIndexOf("->");
        //注意点1
        idx = idx == -1 ? 0 : idx;
        path.delete(idx, path.length());
    }


    //    [1,2,3,null,5]
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");

    }
}
