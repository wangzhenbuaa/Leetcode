import java.util.ArrayList;
import java.util.List;

public class Leetcode547 {
    boolean[] vis;

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int N = M.length;
        vis = new boolean[N];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (vis[i] == false) {
                DFS(M, i);
                ans++;
            }
        }
        return ans;
    }

    private void DFS(int[][] M, int idx) {
        int N = M.length;
        vis[idx] = true;
        for (int i = 0; i < N; i++) {
            if (M[idx][i] == 1) {
                M[idx][i] = M[i][idx] = 0;//关系解除，防止陷入死循环
                DFS(M, i);
            }
        }
    }

/*    private List<Integer>[] generateGraph(int[][] M) {
        int N = M.length;
        List<Integer>[] G = new List[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (M[i][j] == 1) {
                    G[i].add(j);
                    G[j].add(i);
                }
            }
        }
        return G;
    }*/

}
