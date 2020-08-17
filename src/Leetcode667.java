public class Leetcode667 {
    //      interval k k-1 k-2 ... 2 1 1 1 1
    //      1 k+1 2 k 3 k-1...k/2 k/2+2 k/2+1 k+2 k+3...n
    public int[] constructArray(int n, int k) {
        int[] nums = new int[n];
        int idx = 0, val1 = 1, val2 = k + 1;
        while (val1 < val2) {
            nums[idx++] = val1++;
            nums[idx++] = val2--;
        }
        if (val1 == val2) nums[idx++] = val1;
        while (idx < n) {
            nums[idx] = idx + 1;
            idx++;
        }
        return nums;
    }
}
