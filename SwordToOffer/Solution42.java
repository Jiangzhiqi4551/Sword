/**
 * @author Jiang
 * @date 2020/3/22 14:32
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution42 {
    public int maxSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int result = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (current < 0) {
                current = nums[i];
            } else {
                current = current + nums[i];
            }
            result = Math.max(result, current);
        }
        return result;
    }
}
