import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class leetcode524 {
    public boolean isMatching(String s, String str) {
        int i = 0, j = 0;
        while (i < s.length() && j < str.length()) {
            if (s.charAt(i) == str.charAt(j)) j++;
            i++;
        }
        if (j == str.length()) return true;
        return false;
    }

    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length();
            }
        });
        for (String str : d) {
            if (isMatching(s, str)) return str;
        }
        return "";
    }
}
