import java.util.Scanner;

public class NetEaseTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            ans += num / 2;
        }
        System.out.println(ans);
    }
}
