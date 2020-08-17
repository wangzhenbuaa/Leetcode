import java.util.*;

//此题先转换为图再求解
public class leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        int start = n - 1;
        int end = 0;
        //此处endWord的“cog”和wordList中的“cog”都来自常量池，故比较是否相等时可直接用==,
        // 但leetcode给的输入是创建的对象，因此用equals方法比较合适
        while (!wordList.get(end).equals(endWord)) {
            end++;
            if (end == n) break;
        }
        System.out.println("end=" + end);
        if (end == n) return 0;//不存在到目标单词的路径
        List<Integer>[] Graph = createGraph(wordList);
        return BFS(Graph, start, end);

    }

    //判断两字符串是否可通
    private boolean judge(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        int difCnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) difCnt++;
            if (difCnt > 1) return false;
        }
        return difCnt == 1;
    }

    //创建图
    private List<Integer>[] createGraph(List<String> wordList) {
        List<Integer>[] G = new List[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            G[i] = new ArrayList<>();
            for (int j = 0; j < wordList.size(); j++) {
                if (judge(wordList.get(i), wordList.get(j))) G[i].add(j);
            }
        }
        return G;
    }

    //BFS
    private int BFS(List<Integer>[] G, int st, int ed) {
        int pathLen = 0;
        boolean[] vis = new boolean[G.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);
        vis[st] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLen++;
            while (size-- > 0) {
                int top = queue.poll();
                if (top == ed) return pathLen;
                for (int e : G[top]) {
                    if (vis[e]) continue;
                    queue.add(e);
                    vis[e] = true;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        String beginWord = "hit";
        String endWord = "cog";
        leetcode127 leetcode = new leetcode127();
        System.out.println(leetcode.ladderLength(beginWord, endWord, wordList));
    }
}
