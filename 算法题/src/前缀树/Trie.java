package 前缀树;

/**
 * @author 彭一鸣 208. 实现 Trie (前缀树) https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @since 2021/4/14 0:18
 */
public class Trie {

    // 里面有两个数据，一个是26个字母的指针，还一个是这个节点是否是最后一位
    private Trie[] child;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        child = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null) {
                node.child[index] = new Trie();
            }
            node = node.child[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.child[index] == null ) {
                return false;
            }
            node = node.child[index];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.child[index] == null ) {
                return false;
            }
            node = node.child[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
