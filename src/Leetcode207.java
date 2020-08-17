import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] G = new List[numCourses];
        int[] inDegree = new int[numCourses];//入度
        for (int i = 0; i < numCourses; i++) {
            G[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            G[pre[1]].add(pre[0]);
            inDegree[pre[0]]++;
        }
        int num = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                num++;
            }
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            for (int next : G[top]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                    num++;
                }
            }
            G[top].clear();
        }
        return num == numCourses;
    }
}
