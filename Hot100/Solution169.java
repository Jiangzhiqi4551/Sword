package Hot100;

/**
 * @author Jiang
 * @date 2020/4/4 22:21
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 输入: [3,2,3]
 * 输出: 3
 */
public class Solution169 {

    public int majorityElement(int[] nums) {

        int tmp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == tmp) {
                count++;
            } else {
                if (count == 0) {
                    tmp = nums[i];
                    count = 1;
                } else {
                    count--;
                }
            }
        }
        return tmp;
    }
}
