import java.util.Scanner;

public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int ans = 0;
        String start = new String("0");
        for (int i = 0; i < n; i++) {
            String[] pos = sc.nextLine().split(" ");
            if (pos[0].equals(pos[1])) {
                ans++;
                start = "0";
            }else if (start.equals(pos[1])) {
                ans++;
                start = "0";
            } else if (start.equals("0")) {
                start = pos[0];
            }
        }
        System.out.println(ans);
    }
}
