import java.util.Scanner;

public class DjiMain3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder str = new StringBuilder(s);
        int k = Integer.parseInt(sc.nextLine());
        int idx = 0;
        boolean flag = true;
        while (k > 0) {
            flag = false;
            for (; idx < str.length() - 1; idx++) {
                if (str.charAt(idx) > str.charAt(idx + 1)) {
                    str.deleteCharAt(idx);
                    flag = true;
                    if (idx > 0) idx--;
                    break;
                }
            }
            if (!flag) break;//不存在下降序列了
            k--;
        }
        while (k-- > 0) {
            str.deleteCharAt(idx--);
        }
        while (str.charAt(0) == '0' && str.length() > 1) {
            str.deleteCharAt(0);
        }
        System.out.println(str);
    }
}
