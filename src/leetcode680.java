import java.util.Scanner;

//可删除一个字符，判断字符串是否为回文串
public class leetcode680 {
    public static boolean judgePalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }


    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return judgePalindrome(s, i + 1, j)
                        || judgePalindrome(s, i, j - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(validPalindrome(str));
    }
}

// aba  abca
