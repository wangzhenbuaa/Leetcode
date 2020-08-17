import java.util.Scanner;

public class PddTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dis = sc.nextInt(), n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (dis == 0) {
            System.out.println("paradox");
            return;
        }
        int backCnt = 0;
        for (int i = 0; i < n; i++) {
            if (dis > nums[i]) dis -= nums[i];
            else if (dis < nums[i]) {
                dis = nums[i] - dis;
                backCnt++;
            } else {
                System.out.println("paradox");
                return;
            }
        }
        System.out.println(dis + " " + backCnt);
    }
}
