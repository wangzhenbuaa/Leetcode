import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] G = new List[numCourses];//邻接矩阵
        for (int i = 0; i < numCourses; i++) {
            G[i] = new ArrayList<>();
        }
        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            G[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                ans.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int next : G[top]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                    ans.add(next);
                }
            }
        }
        if (ans.size() != numCourses) return new int[0];
        int[] res = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
