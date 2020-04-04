package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/4/4 21:39
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 *
 * 思路：获取数组中的每个数字，将数字对应位置的元素设置为负值，再对数组做遍历，如果哪一个位置上的元素不是负值，说明元素对应位置的值没出现过，即为没出现过的数字
 */
public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>(0);
        }

        for (int i = 0; i < nums.length; ++i) {
            int tmp = nums[i];
            tmp = Math.abs(tmp);
            tmp--;
            nums[tmp] = -1 * Math.abs(nums[tmp]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
