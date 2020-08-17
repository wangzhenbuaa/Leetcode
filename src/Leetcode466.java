public class Leetcode466 {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int idx1 = 0, idx2 = 0;
        int numRound1 = 0, numRound2 = 0;
        int lastIdx2 = 0;//上一轮s1的idx2
        int lastRound2 = -1;//上一轮s1的numRound2
        while (true) {
            while (idx1 < s1.length() && idx2 < s2.length()) {
                if (s1.charAt(idx1) == s2.charAt(idx2)) {
                    idx2++;
                }
                idx1++;
            }
            if (idx1 == s1.length() && idx2 == s2.length()) {//s1和s2刚好遍历完的情况
                numRound1++;
                numRound2++;
                break;
            }
            if (idx1 == s1.length()) {
                if (lastIdx2 == idx2 && lastRound2 == numRound2) {//s1一轮下来idx2不再移动
                    return 0;
                }
                numRound1++;
                if (idx2 == 0 && numRound2 != 0) {//这也是s1和s2刚好遍历完的情况,如案例1
                    break;
                }
                if (idx2 == lastIdx2 && numRound2 != 0) {//这种两者步长相等，如案例2
                    return (int) (n1 - (numRound1 - numRound2)) / n2;
                }
                idx1 = 0;
                lastIdx2 = idx2;
                lastRound2 = numRound2;
            }
            if (idx2 == s2.length()) {
                numRound2++;
                idx2 = 0;
            }
        }
        return (int) numRound2 * n1 / (numRound1 * n2);
    }

    public static void main(String[] args) {
        String str1 = "ecbafedcba";
        String str2 = "abcdef";
        System.out.println(getMaxRepetitions(str1, 4, str2, 1));
    }

    /*
    * 案例1：abc ab
    * 案例2：bacaba  abacab
    * 案例3：ecbafedcba abcdef
    * */
}
