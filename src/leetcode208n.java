public class leetcode208n {
    /**
     * Initialize your data structure here.
     */
    private class Node {
        Node[] childs = new Node[26];//新建数组，但数组里的对象需重新实例化一遍
        boolean isLeaf;
    }

    private Node root = new Node();

    public leetcode208n() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(word, root);
    }

    //将一个字符串插入前缀树
    private void insert(String word, Node node) {
        if (node == null) return;
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int idx = word.charAt(0) - 'a';
        if (node.childs[idx] == null) node.childs[idx] = new Node();//新建结点，其实就是实例化Node
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
        if (word.length() == 0) {
            if (node.isLeaf) return true;
            else return false;
        }
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
