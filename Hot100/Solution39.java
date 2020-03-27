package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/27 14:28
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 思路： 回溯法
 * 回溯法框架：
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * <p>
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 */
public class Solution39 {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>(0);
        }

        Arrays.sort(candidates);
        LinkedList<Integer> tmp = new LinkedList<>();

        helper(candidates, tmp, target, 0, 0);
        return result;
    }

    public void helper(int[] nums, LinkedList<Integer> tmp, int target, int current, int index) {
        if (current == target) {
            result.add(new LinkedList<>(tmp));
            // result.add(tmp);
            return;
        }
        if (current > target) {
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            tmp.add(nums[i]);
            helper(nums, tmp, target, current + nums[i], i);
            tmp.removeLast();
        }
    }
}
