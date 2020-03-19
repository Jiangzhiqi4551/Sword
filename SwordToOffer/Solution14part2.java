/**
 * @author Jiang
 * @date 2020/3/19 14:14
 */
public class Solution14part2 {

    public int cuttingRope(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        long result = 1;
        while (n > 4) {
            result = (result * 3) % 1000000007;
            n = n - 3;
        }

        return (int) ((result * n) % 1000000007);
    }
}
