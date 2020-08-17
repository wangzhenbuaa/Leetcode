import java.util.Arrays;

public class Leetcode785 {

    private boolean paint(int[][] graph, int[] colors, int curColor, int curNode) {
        if (colors[curNode] != -1) return colors[curNode] == curColor;//上过色的直接返回
        colors[curNode] = curColor;
        for (int nextNode : graph[curNode]) {
            if (!paint(graph, colors, 1 - curColor, nextNode)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {//处理图不是联通的情况
            if (colors[i] == -1 && !paint(graph, colors, 0, i)) {
                return false;
            }
        }
        return true;
    }
}
