import java.util.*;

public class TestMapSort {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> chars = Arrays.asList('a', 'd', 'a', 'c');
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> el : list) {
            System.out.print(el.getKey() + " ");
        }
    }
}
