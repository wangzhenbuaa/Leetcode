import java.util.*;

public class testSort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("b", "a", "c"));
        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length();
            }
        });
        System.out.println(list);
        System.out.println("ca".compareTo("bb"));
        System.out.println(55 + "bb");
    }
}
