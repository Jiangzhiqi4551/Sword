package Hot100;

/**
 * @author Jiang
 * @date 2020/3/25 10:23
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class Solution05 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); ++i) {
            int tmpMaxSingle = getLength(i, i, s);
            int tmpMaxDouble = getLength(i, i + 1, s);
            int tmpMax = (tmpMaxSingle > tmpMaxDouble) ? tmpMaxSingle : tmpMaxDouble;
            if (tmpMax > right - left) {
                left = i - (tmpMax - 1) / 2;
                right = i + tmpMax / 2;
            }
        }
        return s.substring(left, right + 1);
    }

    public int getLength(int left, int right, String s) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - 1 - (left + 1) + 1;
    }
}
