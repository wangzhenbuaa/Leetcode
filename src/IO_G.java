import java.util.Scanner;

public class IO_G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int sum = 0;
            String[] arr = sc.nextLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            System.out.println(sum);
        }
    }
}
