import java.util.Arrays;
import java.util.Scanner;

public class IO_H2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(" ");
        }
    }
}
