//改代码作为一个错误的示范，主要是 if(node==null) node = new Node()这里有问题
public class leetcode208 {
    private class Node {
        Node[] childs = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    /**
     * Initialize your data structure here.
     */
    public leetcode208() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(word, root);
    }

    //将一个字符串插入前缀树
    private void insert(String word, Node node) {
        if (node == null) {//这样没有和根节点建立联系
            node = new Node();
        }
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int idx = word.charAt(0) - 'a';
        insert(word.substring(1), node.childs[idx]);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    //查找前缀树中是否含给定字符串
    private boolean search(String word, Node node) {
        if (node == null) return false;
        if (word.length() == 0 && node.isLeaf) return true;
        int idx = word.charAt(0) - 'a';
        return search(word.substring(1), node.childs[idx]);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    //查找前缀树中是否含给定字符串前缀
    private boolean startsWith(String prefix, Node node) {
        if (node == null) return false;
        if (prefix.length() == 0) return true;
        int idx = prefix.charAt(0) - 'a';
        return startsWith(prefix.substring(1), node.childs[idx]);
    }
}
