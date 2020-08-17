import java.util.Scanner;
//不断输入两个整数
public class IO_A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(sc.nextInt() + sc.nextInt());
        }
    }
}
