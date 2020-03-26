package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/26 22:24
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return new ArrayList<>(0);
        }

        List<String> list = new ArrayList<>();
        helper(list, 0, 0, n, "");
        return list;


    }

    public void helper(List<String> list, int open, int close, int num, String tmp) {

        if (tmp.length() == 2 * num) {
            list.add(tmp);
            return;
        }

        if (open < num) {
            helper(list, open + 1, close, num, tmp + "(");
        }
        if (close < open) {
            helper(list, open, close + 1, num, tmp + ")");
        }
    }

}
