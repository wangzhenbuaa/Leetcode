public class Leetcode287n {
    //二分法
    public int findDuplicate(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low<high){
            int cnt=0;
            int mid = low+(high-low)/2;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid) cnt++;
            }
            if(cnt>mid) high = mid;
            else low=mid+1;
        }
        return low;
    }
}
