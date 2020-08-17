import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Leetcode79 {
    private int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] vis;
    char[][] board;
    int m, n;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(i, j, 0, word)) return true;
            }
        }
        return false;
    }

    private boolean backtracking(int row, int col, int curLen, String word) {
        if (curLen == word.length()) return true;
        if (row < 0 || row >= m || col < 0 || col >= n || vis[row][col] || board[row][col] != word.charAt(curLen)) {
            return false;
        }
        vis[row][col] = true;
        boolean flag = false;
        for (int[] d : direction) {
            int nextR = row + d[0], nextC = col + d[1];
            flag = flag || backtracking(nextR, nextC, curLen + 1, word);
        }
        vis[row][col]=false;
        return flag;
    }

    /*
3 4
A B C E
S F C S
A D E E
SEE
    * */
//论如何输入字符数组
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int m = Integer.parseInt(arr[0]), n = Integer.parseInt(arr[1]);
        char[][] board = new char[m][n];
        String[] strs = new String[m];
        for (int i = 0; i < m; i++) {
            strs[i] = sc.nextLine();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = strs[i].charAt(2 * j);
            }
        }
        String word = sc.nextLine();
        Leetcode79 leetcode79 = new Leetcode79();
        System.out.println(leetcode79.exist(board, word));
    }

}
