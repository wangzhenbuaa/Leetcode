import java.util.Arrays;
import java.util.Scanner;

public class IO_H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();//用sc.nextLine接收数字后的换行，不要用sc.next()
        String[] arr = sc.nextLine().split(" ");
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(" ");
        }
    }
}
