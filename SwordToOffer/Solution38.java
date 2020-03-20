import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiang
 * @date 2020/3/19 16:07
 * 输入一个字符串，打印出该字符串中字符的所有排列。不能有重复元素
 */
public class Solution38 {

    public String[] permutation(String s) {

        Set<String> set = new HashSet<>();
        if (s == null) {
            return new String[0];
        }
        boolean[] isVisited = new boolean[s.length()];
        process(s, "", isVisited, set);
        return set.toArray(new String[set.size()]);
    }

    private void process(String s, String letter, boolean[] isVisites, Set<String> set) {

        if (s.length() == letter.length()) {
            set.add(letter);
            return;
        }
        for (int i = 0; i < s.length(); ++i) {
            char tmp = s.charAt(i);
            if (isVisites[i]) {
                continue;
            }
            isVisites[i] = true;
            process(s, letter + String.valueOf(tmp), isVisites, set);
            isVisites[i] = false;
        }
    }
}
