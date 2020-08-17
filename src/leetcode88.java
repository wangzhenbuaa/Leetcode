// 归并有序数组
public class leetcode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            nums[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            nums[k++] = nums1[i++];
        }
        while (j < n) {
            nums[k++] = nums2[j++];
        }
        for (int t = 0; t < m + n; t++) {
            nums1[t] = nums[t];
        }
    }

}
