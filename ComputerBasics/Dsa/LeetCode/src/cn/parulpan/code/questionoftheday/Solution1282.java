package cn.parulpan.code.questionoftheday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1282. 用户分组
 * https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 * <p>
 * data structure: 字符串 哈希
 * algorithm: 模拟
 *
 * @author parzulpan
 * @since 2022/08/12
 */
public class Solution1282 {
    public static void main(String[] args) {
        System.out.println(new Solution1282().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
        System.out.println(new Solution1282().groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
    }

    /**
     * 可以使用哈希表将所属组大小相同的下标放到一起. 假设组大小为 k 的元素有 m 个, 然后我们再将这 m 个元素按照 k 个一组进行划分即可.
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>(500);
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (Integer k : map.keySet()) {
            List<Integer> list = map.get(k);
            ArrayList<Integer> cur = new ArrayList<>();
            for (Integer integer : list) {
                cur.add(integer);
                if (cur.size() == k) {
                    ans.add(cur);
                    cur = new ArrayList<>();
                }
            }
        }

        return ans;
    }
}
