import javax.print.DocFlavor;
import java.util.*;

public class leetcode451 {
    public static String frequencySort(String s) {
        Map<Character, Integer> charNum = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charNum.put(ch, charNum.getOrDefault(ch, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> charFre = new ArrayList<Map.Entry<Character, Integer>>(charNum.entrySet());
        Collections.sort(charFre, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charFre) {
            int num = entry.getValue();
            for (int i = 0; i < num; i++) {
                str.append(entry.getKey());
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(frequencySort(str));
    }
}
