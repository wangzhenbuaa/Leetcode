public class leetcode677 {
    /**
     * Initialize your data structure here.
     */
    private class Node {
        int val;
        Node[] childs = new Node[128];
    }

    private Node root = new Node();

    public leetcode677() {

    }

    public void insert(String key, int val) {
        insert(key, val, root);
    }

    private void insert(String key, int val, Node node) {
        if (node == null) return;
        if (key.length() == 0) {
            node.val = val;
            return;
        }
        int idx = key.charAt(0) - 'a';
        if (node.childs[idx] == null) node.childs[idx] = new Node();
        insert(key.substring(1), val, node.childs[idx]);
    }

    public int sum(String prefix) {
        return sum(prefix, root);
    }

    private int sum(String prefix, Node node) {
        if (node == null) return 0;
        if (prefix.length() == 0) {
            return calNodeValSum(node);
        }
        int idx = prefix.charAt(0) - 'a';
        return sum(prefix.substring(1), node.childs[idx]);
    }

    private int calNodeValSum(Node node) {
        if (node == null) return 0;
        int sum = node.val;
        for (int i = 0; i < 128; i++) {
            sum += calNodeValSum(node.childs[i]);
        }
        return sum;
    }
}
