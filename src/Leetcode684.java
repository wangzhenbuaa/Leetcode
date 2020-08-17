public class Leetcode684 {
    //并查集
    int[] father;

    private int findFather(int x) {
        int a = x;
        while (x != father[x]) {
            x = father[x];
        }
        while (father[a] != x) {//路径压缩
            int temp = father[a];
            father[a] = x;
            a = temp;
        }
        return x;
    }

/*    private void union(int x, int y) {
        int faX = findFather(x);
        int faY = findFather(y);
        if (faX != faY) father[faY] = faX;
    }*/

    public int[] findRedundantConnection(int[][] edges) {
        father = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {//初始化
            father[i] = i;
        }
        for (int[] edge : edges) {
            int fa0 = findFather(edge[0]), fa1 = findFather(edge[1]);
            if (fa0 != fa1) father[fa1] = fa0;
            else return edge;
        }
        return edges[edges.length - 1];
    }
}
