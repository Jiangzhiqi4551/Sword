package Hot100;

import java.util.*;

/**
 * @author Jiang
 * @date 2020/3/28 21:04
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class Solution49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>(0);
        }

        Map<String, List> map = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String sortedString = String.valueOf(tmp);
            if (map.containsKey(sortedString)) {
                List list = map.get(sortedString);
                list.add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sortedString, list);
            }
        }

        return (new ArrayList(map.values()));
    }
}
