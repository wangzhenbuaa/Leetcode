import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class Leetcode697 {
    public int findShortestSubArray(int[] nums) {
        int[] cnt = new int[50010];
        int maxCnt = 0;
        List<Integer> maxNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] < maxCnt) continue;
            else if (cnt[i] == maxCnt) maxNums.add(i);
            else {
                maxNums.clear();
                maxNums.add(i);
                maxCnt = cnt[i];
            }
        }
        for(int i:maxNums){
            System.out.println(i);
        }
        int res = 1 << 30;
        for (int maxNum : maxNums) {
            int begin = -1, end = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == maxNum) {
                    if (begin == -1) begin = i;
                    end = i;
                }
            }
            res = Math.min(res, end - begin + 2);
        }
        return res;
    }

}
