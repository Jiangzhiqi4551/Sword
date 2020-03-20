/**
 * @author Jiang
 * @date 2020/3/20 16:12
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 */
public class Solution67 {

    public int strToInt(String str) {

        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        long result = 0;
        boolean flag = true; // true + ; false -

        if (str.charAt(0) != '+' && str.charAt(0) != '-' && !Character.isDigit(str.charAt(0))) {
            return 0;
        }
        if (str.charAt(0) == '-') {
            flag = false;
        }
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            str = str.substring(1);
        }

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                if (flag) {
                    return (int) result;
                } else {
                    return -(int) result;
                }
            } else {
                result = result * 10 + c - '0';
            }
            if (result > Integer.MAX_VALUE) {
                if (flag) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        if (flag) {
            return (int) result;
        } else {
            return -(int) result;
        }
    }
}
