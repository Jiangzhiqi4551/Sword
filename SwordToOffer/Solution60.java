/**
 * @author Jiang
 * @date 2020/3/21 11:04
 */
public class Solution60 {

    public double[] twoSum(int n) {

        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; ++i) {
            for (int s = i; s <= 6 * i; s++) {
                for (int d = 1; d <= 6; d++) {
                    if (s - d < i - 1) {
                        break;
                    }
                    dp[i][s] += dp[i - 1][s - d];
                }
            }
        }
        double total = Math.pow(6.0, n);
        double[] result = new double[n * 5 + 1];
        for (int i = n; i <= 6 * n; i++) {
            result[i - n] = (double) dp[n][i] / total;
        }
        return result;
    }
}
