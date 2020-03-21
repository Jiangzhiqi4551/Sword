/**
 * @author Jiang
 * @date 2020/3/21 10:18
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 输入: n = 3
 * 输出: 6
 */
public class Solution64 {

    public int sumNums(int n) {

        boolean b = (n > 0) && ((n = n + sumNums(n - 1)) > 0);
        return n;
    }
}
