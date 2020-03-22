/**
 * @author Jiang
 * @date 2020/3/22 13:50
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 */
public class Solution44 {
    public int findNthDigit(int n) {
        int[] level = new int[10];
        level[0] = 0;
        level[1] = 9;
        level[2] = level[1] + 180;
        level[3] = level[2] + 3 * 900;
        level[4] = level[3] + 4 * (9999 - 1000 + 1);
        level[5] = level[4] + 5 * (99999 - 10000 + 1);
        level[6] = level[5] + 5400000;  // 100000 - 999999
        level[7] = level[6] + 63000000; // 1000000 - 9999999
        level[8] = level[7] + 720000000;// 10000000 - 99999999
        level[9] = Integer.MAX_VALUE;

        if (n <= 0) {
            return 0;
        }

        int i = 0;
        while (true) {
            if (level[i] < n && level[i + 1] >= n) {
                break;
            }
            i++;
        }
        int offset = (n - level[i] - 1) / (i + 1);
        int remainder = (n - level[i] - 1) % (i + 1);

        int num = (int) (Math.pow(10, i) + offset);
        int bit = 0;
        for (int j = i; i >= remainder; --j) {
            bit = num % 10;
            num = num / 10;
        }
        return bit;
    }
}
