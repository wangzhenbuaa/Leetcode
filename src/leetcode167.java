import java.util.Scanner;

public class leetcode167 {
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] res = twoSum(numbers, target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

/*
4
2 7 11 15
9
*/
