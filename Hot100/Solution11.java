package Hot100;

/**
 * @author Jiang
 * @date 2020/3/26 15:39
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class Solution11 {

    public int maxArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxSize = 0;
        int currentHeight = 0;
        int currentWide = 0;
        int currentArea = 0;
        while (left < right) {
            currentHeight = height[left] > height[right] ? height[right] : height[left];
            currentWide = right - left;
            currentArea = currentHeight * currentWide;
            maxSize = Math.max(maxSize, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxSize;
    }
}
