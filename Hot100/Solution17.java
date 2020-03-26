package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/26 16:59
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution17 {

    private String[] phone = new String[]{
            "",
            "",
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    private ArrayList<String> tmp = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>(0);
        }
        helper(digits, 0, "");
        return tmp;
    }

    public void helper(String digits, int index, String cur) {
        if (index == digits.length()) {
            tmp.add(cur);
            return;
        }

        char c = digits.charAt(index);
        int num = c - '0';
        String phoneString = phone[num];
        for (int i = 0; i < phoneString.length(); ++i) {
            helper(digits, index + 1, cur + phoneString.charAt(i));
        }
    }
}
