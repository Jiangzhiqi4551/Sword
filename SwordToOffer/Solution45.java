import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiang
 * @date 2020/3/20 15:07
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 输入: [10,2]
 * 输出: "102"
 */
public class Solution45 {

    public String minNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(nums[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                String s1 = o1 + "" + o2;
                String s2 = o2 + "" + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder builder = new StringBuilder();
        for (Integer integer : list) {
            builder.append(integer);
        }

        return builder.toString();
    }
}
