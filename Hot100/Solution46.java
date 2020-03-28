package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/28 16:11
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 思路：回溯法
 */
public class Solution46 {
    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }
        LinkedList<Integer> list = new LinkedList<>();
        helper(list, 0, nums, new int[nums.length]);
        return result;
    }

    public void helper(LinkedList<Integer> list, int index, int[] nums, int[] isVisited) {

        if (index == nums.length) {
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (isVisited[i] == 1) continue;
            isVisited[i] = 1;
            list.add(nums[i]);
            helper(list, index + 1, nums, isVisited);
            isVisited[i] = 0;
            list.removeLast();
        }
    }
}
