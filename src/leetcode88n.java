//归并有序数组，这道题默认nums1[]足够大，因此从尾部开始归并，可避免重新开辟数组
public class leetcode88n {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1, idx2 = n - 1, idx = m + n - 1;
        while (idx1 >= 0 && idx2 >= 0) {
            nums1[idx--] = nums1[idx1] >= nums2[idx2] ? nums1[idx1--] : nums2[idx2--];
        }
        while (idx1 >= 0) {
            nums1[idx--] = nums1[idx1--];
        }
        while ((idx2 >= 0)) {
            nums1[idx--] = nums2[idx2--];
        }
    }
}
