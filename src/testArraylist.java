import java.util.ArrayList;
import java.util.List;

public class testArraylist {
    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>();
        //新元素坐到指定位置，其他元素往后挪一个位置
        queue.add(0, 5);
        queue.add(1, 6);
        queue.add(1, 7);
        System.out.println(queue);
        queue.add(0, 10);
        System.out.println(queue);
        Object[] obj = queue.toArray();
        for (Object i : obj) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        Integer[] ans = queue.toArray(new Integer[queue.size()]);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        Integer[] ans2 = new Integer[queue.size()];
        ans2 = queue.toArray(ans2);
        for (int i : ans2) {
            System.out.print(i + " ");
        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.remove(list.size()-1);
        System.out.println("----------------");
        System.out.println(list);

    }
}
