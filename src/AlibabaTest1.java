import java.util.Scanner;

public class AlibabaTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] f0 = new int[n + 1];
        int[] f1 = new int[n + 1];
        f0[1] = 0;
        f1[1] = f1[2] = f0[2] = 1;
        for (int i = 3; i <= n; i++) {
            f0[i] = (i - 1) * (f0[i - 2] + f1[i - 2] * (i - 2));
            f1[i] = f0[i - 1] + (i - 1) * f1[i - 1];
        }
        System.out.println(f0[n]);
    }
}
