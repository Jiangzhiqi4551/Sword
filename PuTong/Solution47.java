package PuTong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/28 18:11
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 思路：回溯法，主要在于怎样去重，先排序，在循环中如果发现这一次的数  和 上一次的数相同时，就可能造成重复，
 * 如果上一次已经回溯过了，就剪枝，如果上一次还在使用中，没回溯完，就留着
 */
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> result = new LinkedList<>();
        int[] isUsed = new int[nums.length];
        LinkedList<Integer> tmp = new LinkedList<>();

        Arrays.sort(nums);
        helper(result, tmp, nums, isUsed);
        return result;
    }

    public void helper(List<List<Integer>> result, LinkedList<Integer> tmp, int[] nums, int[] isUsed) {

        if (tmp.size() == nums.length) {
            result.add(new LinkedList<>(tmp));
        }

        for (int i = 0; i < nums.length; ++i) {
            if (isUsed[i] == 1) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && isUsed[i - 1] == 0) {
                continue;
            }
            tmp.add(nums[i]);
            isUsed[i] = 1;
            helper(result, tmp, nums, isUsed);
            tmp.removeLast();
            isUsed[i] = 0;
        }
    }
}
