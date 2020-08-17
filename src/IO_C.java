import java.util.Scanner;

public class IO_C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt(), b = sc.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }
}
