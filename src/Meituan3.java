import java.util.*;

public class Meituan3 {
    static int[] father;

    static int findFather(int x) {
        int a = x;
        while (father[x] != x) {
            x = father[x];
        }
        while (father[a] != a) {
            int temp = father[a];
            father[a] = x;
            a = temp;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            int faX = findFather(x), faY = findFather(y);
            if (faX != faY) {
                father[faY] = faX;
            }
        }
        Map<Integer, Set<Integer>> res = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int root = findFather(i);
            if (!res.containsKey(root)) {
                res.put(root, new HashSet<>());
            }
            res.get(root).add(i);
        }
        System.out.println(res.size());
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer el : res.keySet()) {
            Set<Integer> tempSet = res.get(el);
            List<Integer> listTemp = new ArrayList<>();
            for (Integer num : tempSet) {
                listTemp.add(num);
            }
            Collections.sort(listTemp);
            ans.add(listTemp);
        }
        Collections.sort(ans, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> temp = ans.get(i);
            for (int j = 0; j < temp.size(); j++) {
                if (j != 0) System.out.print(" ");
                System.out.print(temp.get(j));
            }
            System.out.println("");
        }
    }
}
