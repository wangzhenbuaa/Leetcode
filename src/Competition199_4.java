import java.util.ArrayList;
import java.util.List;

public class Competition199_4 {
    public static int getLengthOfOptimalCompression(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        char pre = s.charAt(0);
        char[] chars = new char[n];
        int[] nums = new int[n];
        int cnt = 0, idx = 1;
        while (idx < n) {
            int ans = 1;
            while (idx < n && s.charAt(idx) == pre) {
                idx++;
                ans++;
            }
            chars[cnt] = pre;
            nums[cnt++] = ans;
            if (idx < n) pre = s.charAt(idx);
            idx++;
        }
        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            numsList.add(nums[i]);
        }

/*
        优先级：
        1 2 10 100优先去除
        3 11
        4 12
        5 13
        6 14
        7 15
        8 16
        9 17
        18 19 20 21...
*/
        List<Integer> priorityLevel = new ArrayList<>();
        priorityLevel.add(1);
        priorityLevel.add(2);
        priorityLevel.add(10);
        priorityLevel.add(100);
        for (int i = 3; i <= 9; i++) {
            priorityLevel.add(i);
            priorityLevel.add(i + 9);
        }
        for (int i = 19; i <= 99; i++) {
            priorityLevel.add(i);
        }
        for (int i = 0; i < priorityLevel.size(); i++) {
            if (k <= 0) break;
            int goal = priorityLevel.get(i);
            if (numsList.contains(goal)) {
                k--;

            }
        }
        return 0;
    }


    public static void main(String[] args) {
        getLengthOfOptimalCompression("abaabbaa", 0);
    }
}
