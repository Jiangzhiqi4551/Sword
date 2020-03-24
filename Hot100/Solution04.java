package Hot100;

import java.util.Arrays;

/**
 * @author Jiang
 * @date 2020/3/24 17:15
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 */
public class Solution04 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] tmp = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, tmp, 0, nums1.length);
        System.arraycopy(nums2, 0, tmp, nums1.length, nums2.length);
        Arrays.sort(tmp);

        if (tmp.length % 2 == 0) {
            int middle = tmp.length / 2;
            return (tmp[middle] + tmp[middle - 1]) / 2.0;
        } else {
            return tmp[tmp.length / 2];
        }
    }
}
