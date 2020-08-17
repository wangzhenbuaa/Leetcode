import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DjiMain1 {
    static int G[][];
    static int d[];
    static boolean vis[];
    static final int INF = 1 << 30;
    static int n, m, ed;

    static void dijkstra(int s) {
        d[s] = 0;
        for (int i = 0; i < n; i++) {
            int u = -1, Min = INF;
            for (int j = 0; j < n; j++) {//找到最小的d[]
                if (!vis[j] && d[j] < Min) {
                    u = j;
                    Min = d[j];
                }
            }
            if (u == -1) return;//剩余结点不连通
            vis[u] = true;
            for (int v = 0; v < n; v++) {
                if (!vis[v] && d[u] + G[u][v] < d[v]) {
                    d[v] = d[u] + G[u][v];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        G = new int[n][n];
        d = new int[n];
        vis = new boolean[n];
        Arrays.fill(d, INF);
        for (int i = 0; i < n; i++) {
            Arrays.fill(G[i], INF);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            G[v][u] = G[u][v] = sc.nextInt();
        }
        ed = sc.nextInt();
        dijkstra(0);
        System.out.println(d[ed]);
    }
}
