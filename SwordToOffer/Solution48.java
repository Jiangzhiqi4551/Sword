import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiang
 * @date 2020/3/22 14:54
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Solution48 {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int result = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            while (set.contains(c)) {
                Character tmp = s.charAt(left);
                set.remove(tmp);
                left++;
            }
            set.add(c);
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }

}
