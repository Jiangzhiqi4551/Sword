/**
 * @author Jiang
 * @date 2020/3/21 15:18
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 输入：nums = [3,4,3,3]
 * 输出：4
 */
public class Solution56part2 {

    public int singleNumber(int[] nums) {
        int[] tmp = new int[32];

        for (int i = 0; i < nums.length; ++i) {
            for (int j = 31; j >= 0; --j) {
                tmp[j] = tmp[j] + (nums[i] & 1);
                nums[i] = nums[i] >> 1;
            }
        }

        int result = 0;
        for (int i = 31; i >= 0; --i) {
            if (tmp[i] % 3 != 0) {
                result = result + (int) Math.pow(2, 31 - i);
            }
        }

        return result;
    }
}
