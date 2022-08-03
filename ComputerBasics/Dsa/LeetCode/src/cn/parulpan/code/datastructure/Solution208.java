package cn.parulpan.code.datastructure;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode.cn/problems/implement-trie-prefix-tree/
 * <p>
 * data structure: 字符串 哈希表
 * algorithm: 设计 字典树
 * <p>
 * Trie 树（又叫「前缀树」或「字典树」）是一种用于快速查询「某个字符串/字符前缀」是否存在的数据结构。
 * 其核心是使用「边」来代表有无字符，使用「点」来记录是否为「单词结尾」以及「其后续字符串的字符是什么」。
 *
 * @author parzulpan
 * @since 2022/07/14
 */
public class Solution208 {
    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");

        // 返回 True
        System.out.println(trie.search("apple"));

        // 返回 False
        System.out.println(trie.search("app"));

        // 返回 True
        System.out.println(trie.startsWith("app"));

        trie.insert("app");

        // 返回 True
        System.out.println(trie.search("app"));
    }
}

/**
 * 时间复杂度：Trie 树的每次调用时间复杂度取决于入参字符串的长度，复杂度为 O(Len)。
 * 空间复杂度：结点数量为 n，字符集大小为 k，复杂度为 O(nk)。
 */
class Trie {
    static class TrieNode {
        boolean end;
        TrieNode[] tns = new TrieNode[26];
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.tns[u] == null) {
                p.tns[u] = new TrieNode();
            }
            p = p.tns[u];
        }
        p.end = true;
    }

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return false;
            }
            p = p.tns[u];
        }
        return p.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.tns[u] == null) {
                return false;
            }
            p = p.tns[u];
        }
        return true;
    }
}