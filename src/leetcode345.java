import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//元音字符倒序
public class leetcode345 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char chi = s.charAt(i);
            char chj = s.charAt(j);
            if (!vowels.contains(chi)) {
                result[i++] = chi;
            }
            if (!vowels.contains(chj)) {
                result[j--] = chj;
            }
            if (vowels.contains(chi) && vowels.contains((chj))) {
                result[i++] = chj;
                result[j--] = chi;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(reverseVowels(word));
    }

}

// hello
