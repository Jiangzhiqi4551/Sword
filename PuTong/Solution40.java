package PuTong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/28 18:47
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * <p>
 * 思路： 回溯法，排序 + isUsed 进行去重 ， for 循环起始位置为 index 保证使用一次
 */
public class Solution40 {

    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>(0);
        }

        Arrays.sort(candidates);
        int[] isVisited = new int[candidates.length];
        LinkedList<Integer> list = new LinkedList<>();
        helper(list, candidates, target, 0, 0, isVisited);

        return result;
    }

    public void helper(LinkedList<Integer> list, int[] candidates, int target, int current, int index, int[] isVisited) {

        if (current == target) {
            result.add(new LinkedList<>(list));
            return;
        }
        if (current > target) {
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            // if(isVisited[i] == 1){
            //     continue;
            // }
            if (i > 0 && candidates[i] == candidates[i - 1] && isVisited[i - 1] == 0) {
                continue;
            }

            isVisited[i] = 1;
            list.add(candidates[i]);
            helper(list, candidates, target, current + candidates[i], i + 1, isVisited);
            isVisited[i] = 0;
            list.removeLast();
        }
    }
}
