import java.util.Stack;

public class Leetcode739 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        int preIdx = 0;
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                preIdx = stack.pop();
                ans[preIdx] = i - preIdx;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = 0;
        }
        return ans;
    }
}
