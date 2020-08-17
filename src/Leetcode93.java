import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    List<String> res = new ArrayList<>();
    List<String> segs = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        DFS(s);
        return res;
    }

    //"010010"
    public void DFS(String s) {
        if (segs.size() == 4) {
            if (s.length() == 0) {
                StringBuilder str = new StringBuilder();
                for (String seg : segs) {
                    str.append(seg);
                    str.append(".");
                }
                str.deleteCharAt(str.length() - 1);
                res.add(str.toString());
            }
            return;
        }
        for (int i = 1; i <= 3 && i <= s.length(); i++) {
            if (s.charAt(0) == '0' && i > 1) break;//首尾为0
            String seg = s.substring(0, i);
            if (Integer.valueOf(seg) <= 255) {
                segs.add(seg);
                DFS(s.substring(i));
                segs.remove(segs.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode93 leetcode93 = new Leetcode93();
        List<String> ans = new ArrayList<>();
        ans = leetcode93.restoreIpAddresses("010010");
        System.out.println(ans);
//        String s = "111";
//        System.out.println(s.substring(3));
//        System.out.println("hah");
    }
}
