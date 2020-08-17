import java.util.Scanner;

public class Leetcode769 {
    public static int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(maxChunksToSorted(nums));
    }
}
