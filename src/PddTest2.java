import java.util.*;

public class PddTest2 {
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void swap2(int[] nums, int i, int j) {
        swap(nums, i, j);
        swap(nums, i + 1, j + 1);
    }

    private static int adjust(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (nums[2 * i] > nums[2 * i + 1]) {
                swap(nums, 2 * i, 2 * i + 1);
                cnt++;
            }
        }
        if (nums[2] == 1) {
            swap2(nums, 0, 2);
            cnt++;
        }
        if (nums[4] == 1) {
            swap2(nums, 0, 4);
            cnt++;
        }
        if (nums[2] > nums[4]) {
            swap2(nums, 2, 4);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[6];
        Map<List<Integer>, Integer> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList();
            for (int j = 0; j < 6; j++) {
                int temp = sc.nextInt();
                nums[j] = temp;
            }
            int cnt = adjust(nums);
            for (int j = 0; j < 6; j++) {
                //System.out.print(nums[j] + " ");
                list.add(nums[j]);
            }
            list.add(cnt % 2);
            int ans = res.getOrDefault(list, 0) + 1;
            res.put(list, ans);
        }
        List<Integer> finalRes = new ArrayList<>();
        for (Integer v : res.values()) {
            finalRes.add(v);
        }
        Collections.sort(finalRes, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(finalRes.size());
        for (int i = 0; i < finalRes.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(finalRes.get(i));
        }
    }

    /*
3
1 2 3 4 5 6
1 2 6 5 3 4
1 2 3 4 6 5

10
2 5 1 3 4 6
5 4 3 2 1 6
1 4 6 2 3 5
1 5 6 3 4 2
6 4 2 1 5 3
3 6 4 5 2 1
1 6 3 4 2 5
5 1 4 2 6 3
6 2 3 1 5 4
5 3 6 1 4 2
   */
}
