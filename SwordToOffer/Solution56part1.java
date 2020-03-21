/**
 * @author Jiang
 * @date 2020/3/21 14:49
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 */
public class Solution56part1 {

    public int[] singleNumbers(int[] nums) {

        int num = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            num = num ^ nums[i];
        }

        int pos = 1;
        while ((num & 1) != 1) {
            num = num >> 1;
            pos = pos << 1;
        }

        int result1 = 0;
        int result2 = 0;
        for (int tmp : nums) {
            if ((tmp & pos) == pos) {
                result1 = result1 ^ tmp;
            } else {
                result2 = result2 ^ tmp;
            }
        }

        return new int[]{result1, result2};
    }
}
