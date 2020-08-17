import java.util.Scanner;

public class PddTest4_ {
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[] graph;
    static int[] plants;
    static int res = 0;//方法数
    static int Num = 0;
    static final int mod = 1000000009;

    //检查周围，看看能不能种该植物
    private static boolean check(int idx, int kind) {
        int row = idx / 6, col = idx % 6;
        for (int[] d : direction) {
            int nextR = row + d[0], nextC = col + d[1];
            if (nextR >= 0 && nextR < 6 && nextC >= 0 && nextC < 6 && plants[nextR * 6 + nextC] == kind) {
                return false;
            }
        }
        return true;
    }

    private static void backtrack(int pos, int cnt) {//pos 位置, cnt 种了几块地
        if (cnt == Num) {//地种完了
            res++;
            res %= mod;
        }
        for (int idx = pos; idx < 36; idx++) {
            if (graph[idx] == '#') {
                for (int k = 1; k <= 6; k++) {//1-6分别表示6种菜，0表示未种
                    if (check(idx, k)) {
                        graph[idx] = '*';
                        plants[idx] = k;
                        backtrack(idx, cnt+1);
                        graph[idx] = '#';
                        plants[idx] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        graph = new char[n * n];
        plants = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                graph[idx++] = str.charAt(j);
            }
        }
        for (int i = 0; i < 36; i++) {
            if (graph[i] == '#') Num++;
        }
        backtrack(0, 0);
        System.out.println(res);
    }
}

/*

##****
##****
******
******
******
******
630

#*****
******
******
******
******
*****#
36

#*****
******
******
******
******
******
6


* */

/*
        for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
        System.out.print(graph[i][j]);
        }
        System.out.println("");
        }*/
