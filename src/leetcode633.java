import java.util.Scanner;

public class leetcode633 {
    public static boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int squareSum = left * left + right * right;
            if (squareSum == c) {
                return true;
            } else if (squareSum < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(judgeSquareSum(n));
    }
}
