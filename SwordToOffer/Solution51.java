import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiang
 * @date 2020/3/21 15:25
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class Solution51 {


    public int reversePairs(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] < nums[i]) {
                    count++;
                    System.out.println(nums[j]);
                    System.out.println(nums[i]);
                }
            }
        }

        return count;
    }

}
