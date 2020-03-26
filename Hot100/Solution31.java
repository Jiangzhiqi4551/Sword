package Hot100;

/**
 * @author Jiang
 * @date 2020/3/26 23:22
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 思路： 从右向左遍历，找到第一个升序对 A B （A < B），从右向左遍历，找到第一个大于 A 的数 C，
 * 交换 A C，对从 B 到结尾的那部分数组做反转
 */
public class Solution31 {

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                --j;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

    }
}
