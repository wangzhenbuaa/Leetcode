import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Leetcode466_n {
    //调整一下思路，找出循环节
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int idx = 0; //s2的下标
        int numRound1 = 0, numRound2 = 0;
        int round1Pre = 0, round2Pre = 0;//进入循环节时s1遍历次数,进入循环节时s2遍历次数
        int num1 = 0, num2 = 0;
        //<idx,<numRound1,numRound2>>
        Map<Integer, Pair<Integer, Integer>> numRounds = new HashMap<>();
        while (true) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(idx)) idx++;
                if (idx == s2.length()) {
                    numRound2++;
                    idx = 0;
                }
            }
            numRound1++;
            if (numRound1 == n1) {
                return (int) numRound2 / n2;
            }
            if (!numRounds.containsKey(idx)) {
                numRounds.put(idx, new Pair<>(numRound1, numRound2));
            } else {
                round1Pre = numRounds.get(idx).getKey();
                round2Pre = numRounds.get(idx).getValue();
                num1 = numRound1 - round1Pre;
                num2 = numRound2 - round2Pre;
                break;
            }
        }
        int numOfRound2 = (n1 - round1Pre) / num1 * num2 + round2Pre;//s2匹配次数
        int remain = (n1 - round1Pre) % num1;
        while (remain-- > 0 && n2 > 0) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(idx)) idx++;
                if (idx == s2.length()) {
                    numOfRound2++;
                    idx = 0;
                }
            }
        }
        return numOfRound2 / n2;
    }

    public static void main(String[] args) {
        String str1 = "baba";
        String str2 = "baab";
        System.out.println(getMaxRepetitions(str1, 11, str2, 1));
    }
}
