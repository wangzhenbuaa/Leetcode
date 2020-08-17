import java.util.Comparator;
import java.util.PriorityQueue;

public class testPriorityQueue {
    public static void main(String[] args) {
        //小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(3);
        queue.add(2);
        System.out.println(queue);//元素可重复
        queue.poll();
        System.out.println(queue);//堆顶最小

        //大顶堆实现
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        queue2.offer(2);
        queue2.offer(3);
        System.out.println(queue2);
    }
}
