package Hot100;

/**
 * @author Jiang
 * @date 2020/3/27 11:36
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int pos = helper(nums, 0, nums.length - 1, target);
        // 一个都没有直接返回 -1 -1
        if (pos == -1) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = 0;
        int lastpos = pos;
        int tmp = pos;

        // 能找到，但是不是在数组头，需要找最左边的
        if (pos != 0) {
            while (nums[tmp] == nums[tmp - 1]) {
                tmp = helper(nums, 0, tmp - 1, target);
                if (tmp == -1) {
                    break;
                }
                if (tmp == 0) {
                    lastpos = 0;
                    break;
                }
                // 缩小范围后，也能找到，记录这次的位置
                lastpos = tmp;
            }
        }
        left = lastpos;

        lastpos = pos;
        // 能找到，但不是在数组尾，需要找到最后的那个
        if (pos != nums.length - 1) {
            while (nums[pos] == nums[pos + 1]) {
                pos = helper(nums, pos + 1, nums.length - 1, target);
                if (pos == -1) {
                    break;
                }
                if (pos == nums.length - 1) {
                    lastpos = nums.length - 1;
                    break;
                }
                lastpos = pos;
            }
        }
        right = lastpos;
        return new int[]{left, right};
    }

    public int helper(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
