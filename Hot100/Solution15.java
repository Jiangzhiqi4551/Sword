package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/26 16:21
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>(0);
        }

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int currentPos = 0;
        while (currentPos < nums.length && nums[currentPos] <= 0) {
            int left = currentPos + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[currentPos]) {
                    result.add(Arrays.asList(nums[currentPos], nums[left], nums[right]));
                    int leftNum = nums[left];
                    while (left < right && leftNum == nums[left]) {
                        left++;
                    }
                    int rightNum = nums[right];
                    while (right > left && rightNum == nums[right]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < -nums[currentPos]) {
                    left++;
                } else {
                    right--;
                }
            }
            int currentPosNum = nums[currentPos];
            while (currentPos < nums.length && currentPosNum == nums[currentPos] && nums[currentPos] <= 0) {
                currentPos++;
            }

        }

        return result;
    }
}
