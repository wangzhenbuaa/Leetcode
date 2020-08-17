public class leetcode9n {
    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0) return false;
        int right = 0;//right 取为x的右半部分并翻转
        while (x > right) {
            right = right * 10 + x % 10;
            x /= 10;
        }
        System.out.println(right);
        return x == right || x == right / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(5));
    }
}
