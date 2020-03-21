import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/21 22:
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class Solution49 {

    public int nthUglyNumber(int n) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        int num2 = 0;
        int num3 = 0;
        int num5 = 0;

        while (list.size() < n) {
            int tmp2 = list.get(num2) * 2;
            int tmp3 = list.get(num3) * 3;
            int tmp5 = list.get(num5) * 5;
            int small = Math.min(tmp2, Math.min(tmp3, tmp5));
            if (small == tmp2) {
                num2++;
            }
            if (small == tmp3) {
                num3++;
            }
            if (small == tmp5) {
                num5++;
            }
            list.add(small);
        }

        return list.get(n - 1);
    }
}
