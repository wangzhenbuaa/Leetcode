import java.util.ArrayList;
import java.util.List;

public class Competition200_4 {
    public int maxSum(int[] nums1, int[] nums2) {
        int idx1=0,idx2=0;
        long sum1=0,sum2=0;
        List<Long> sums1 = new ArrayList<>();
        List<Long> sums2 = new ArrayList<>();
        while (idx1<nums1.length&&idx2<nums2.length){
            if(nums1[idx1]<nums2[idx2]) {
                sum1+=nums1[idx1++];
            }
            else if(nums1[idx1]>nums2[idx2]){
                sum2+=nums2[idx2++];
            }
            else {
                sum1+=nums1[idx1++];
                sum2+=nums2[idx2++];
                sums1.add(sum1);
                sums2.add(sum2);
                sum1=0;
                sum2=0;
            }
        }
        while (idx1<nums1.length){
            sum1+=nums1[idx1++];
        }
        while (idx2<nums2.length){
            sum2+=nums2[idx2++];
        }
        sums1.add(sum1);
        sums2.add(sum2);
        int mod = 1000000007;
        long ans = 0;
        for(int i=0;i<sums1.size();i++){
            ans+=Math.max(sums1.get(i),sums2.get(i));
            ans%=mod;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(1000000007);
    }
}
