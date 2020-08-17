import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;

//此题贪心算法是陷阱，分类讨论双指针才是王道
public class PddTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), T = sc.nextInt();
        int[][] lunch = new int[N][2];
        int[][] diner = new int[M][2];
        for (int i = 0; i < N; i++) {
            lunch[i][0] = sc.nextInt();
            lunch[i][1] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            diner[i][0] = sc.nextInt();
            diner[i][1] = sc.nextInt();
        }
        if (T == 0) {
            System.out.println(0);
            return;
        }
        Arrays.sort(lunch, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Arrays.sort(diner, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        if (lunch[N - 1][1] + diner[M - 1][1] < T) {
            System.out.println(-1);
            return;
        }
        int minFood = 1 << 30;
        for (int i = 0; i < N; i++) {
            if (lunch[i][1] >= T) {
                minFood = Math.min(minFood, lunch[i][0]);
            }
        }
        for (int i = 0; i < M; i++) {
            if (diner[i][1] >= T) {
                minFood = Math.min(minFood, diner[i][0]);
            }
        }
        int idx1 = 0, idx2 = M - 1;
        while (idx1 < N && idx2 >= 0) {
            if (lunch[idx1][1] + diner[idx2][1] < T) {
                idx1++;
            } else {
                minFood = Math.min(minFood, lunch[idx1][0] + diner[idx2][0]);
                idx2--;
            }
        }
        System.out.println(minFood);
    }
    /*
3 3 10
1 1
2 5
3 7
2 4
4 8
6 9
输出 5

2 1 4
3 1
2 1
1 2
输出 -1
    * */
}
