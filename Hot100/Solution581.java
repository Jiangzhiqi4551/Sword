package Hot100;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Jiang
 * @date 2020/3/29 21:10
 * <p>
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return 0;
        }

        LinkedList<Integer> list = new LinkedList<>();
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != tmp[i]) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return 0;
        }
        int first = list.getFirst();
        int last = list.getLast();
        return last - first + 1;
    }
}
