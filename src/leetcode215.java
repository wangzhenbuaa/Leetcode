import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }
}
