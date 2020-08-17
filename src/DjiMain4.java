import java.util.*;

public class DjiMain4 {
    static class User {
        int id;
        int st, ed;
        int val;
    }

    private static int trans(int st, int ed) {
        int ans = 0;
        if (st < 6) {
            if (ed < 6) {
                ans += (st - ed) * 10;
            } else if (ed < 10) {
                ans += (6 - st) * 10 + (ed - 6) * 5;
            } else if (ed > 10) {
                ans += (6 - st) * 10 + (10 - 6) * 5 + (ed - 10) * 2;
            }
        } else if (st < 10) {
            if (ed < 10) {
                ans += (ed - st) * 5;
            } else if (ed > 10) {
                ans += (10 - st) * 5 + (ed - 10) * 2;
            }
        } else {
            ans += (ed - st) * 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        int n = strs.length;
        List<User> users = new ArrayList<>();
        int maxEndTime = 0;
        for (int i = 0; i < n; i++) {
            String[] temps = strs[i].split(" ");
            User user = new User();
            user.id = Integer.parseInt(temps[0]);
            user.st = Integer.parseInt(temps[1]);
            user.ed = Integer.parseInt(temps[2]);
            user.val = trans(user.st, user.ed);
            users.add(user);
        }
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.st - o2.st;
            }
        });
        int[] dp = new int[maxEndTime + 1];
        for (User user : users) {
            for (int i = maxEndTime; i >= user.st; i--) {
            }
        }


    }
}
