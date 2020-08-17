import javafx.util.Pair;

import java.util.*;

public class Meituan1 {
    private static int reverse(int num) {
        StringBuilder str2 = new StringBuilder();
        str2.append(num);
        str2.reverse();
        int num2 = Integer.valueOf(str2.toString());
        return num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Pair<Integer, Integer>> res = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            int num2 = reverse(i);
            if (num2 <= n) {
                if (i * 4 == num2) {
                    res.add(new Pair<>(i, num2));
                } else if (i == num2 * 4) {
                    res.add(new Pair<>(num2, i));
                }
            }
        }
        List<Pair<Integer, Integer>> res2 = new ArrayList<>();
        for (Pair el : res) {
            res2.add(el);
        }
        Collections.sort(res2, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey()-o2.getKey();
            }
        });
        System.out.println(res2.size());
        for (Pair element : res2) {
            System.out.println(element.getKey() + " " + element.getValue());
        }
    }
}
