import java.util.ArrayList;
import java.util.List;

public class Leetcode17 {
    private static final String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    String digits;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return res;
        this.digits = digits;
        StringBuilder str = new StringBuilder();
        combination(str);
        return res;
    }

    private void combination(StringBuilder prefix) {
        if (prefix.length() == digits.length()) {
            res.add(prefix.toString());
            return;
        }
        String key = keys[digits.charAt(prefix.length()) - '0'];
        for (char ch : key.toCharArray()) {
            prefix.append(ch);
            combination(prefix);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
