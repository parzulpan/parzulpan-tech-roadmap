package cn.parulpan.code.questionoftheday;

/**
 * 676. 实现一个魔法字典
 * https://leetcode.cn/problems/implement-magic-dictionary/
 * <p>
 * data structure: 字符串 哈希表
 * algorithm: 设计 字典树
 *
 * @author parzulpan
 * @since 2022/07/11
 */
public class Solution676 {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dictionary = {"hello", "leetcode"};
        magicDictionary.buildDict(dictionary);
        magicDictionary.search("hello");
        magicDictionary.search("hhllo");
        magicDictionary.search("hell");
        magicDictionary.search("leetcoded");
    }
}

class MagicDictionary {

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {


    }

    public boolean search(String searchWord) {


        return false;
    }
}
