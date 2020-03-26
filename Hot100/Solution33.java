package Hot100;

/**
 * @author Jiang
 * @date 2020/3/27 0:18
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * <p>
 * 思路： 先找旋转数组的最小值所在的下标，即旋转数组的分割点，再在左半部分，或右半部分中二分查找
 */
public class Solution33 {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return (nums[0] == target) ? 0 : -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) >> 1;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else if (nums[middle] < nums[right]) {
                right = middle;
            } else {
                right--;
            }
        }

        System.out.println(left);
        //分割点在left
        if (target == nums[left]) {
            return left;
        } else if (target < nums[right]) {
            // 要找的点在 右半部分
            if (target == nums[right]) {
                return right;
            }
            right = nums.length - 1;
        } else {
            // 在左半部分
            right = left - 1;
            left = 0;
            if (right < 0) {
                left = 0;
                right = nums.length - 1;
            }
        }

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
