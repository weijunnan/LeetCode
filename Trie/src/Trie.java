import java.util.TreeMap;
public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord=isWord;
            next = new TreeMap<>();
        }

    }

    private Node root;
    private int size;

    public  Trie() {
        root = new Node();
        size=0;
    }

    public int getSize() {
        return size;
    }

    //添加Tire元素的方法
    public void add(String word) {
        //初始化节点
        Node cur=root;
        //遍历整个字符串word,获取字符
        for (int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);

        }
        if(!cur.isWord){
            cur.isWord=true;
            size++;
        }
    }

    //查询单词word 是否在Tire中
    public boolean Contain(String word) {
        Node cur = root;
        for (int i = 0; i < word.length() - 1; i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    //查询是否在Trie中有单词以preifx为前缀
    public boolean Prefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length() - 1; i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur.next.get(c);
        }
        return true;
    }


}
