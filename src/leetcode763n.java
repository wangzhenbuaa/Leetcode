import java.util.ArrayList;
import java.util.List;

public class leetcode763n {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return null;
        int[] lastIndex = new int[26];//记录每个字符最后一次出现的位置
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int st = 0, ed = 0;
        for (int i = 0; i < S.length(); i++) {
            ed = Math.max(ed, lastIndex[S.charAt(i) - 'a']);
            if (i == ed) {
                res.add(ed - st + 1);
                st = i + 1;
            }
        }
        return res;
    }
}
