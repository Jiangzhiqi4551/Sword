/**
 * @author Jiang
 * @date 2020/3/19 13:59
 */
public class Solution14part1 {

    public int cuttingRope(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int result = 1;
        while (n > 4) {
            result = result * 3;
            n = n - 3;
        }

        return result * n;
    }
}
