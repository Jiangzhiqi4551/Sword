package Hot100;

/**
 * @author Jiang
 * @date 2020/3/28 16:59
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 思路： 图像顺时针旋转90度，需要先将图像做水平对称，再将对称后的图像按对角线做对称
 */
public class Solution48 {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix[0].length == 0) {
            return;
        }

        // 先做水平对称
        for (int i = 0; i < matrix.length / 2; ++i) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[matrix.length - i - 1];
            matrix[matrix.length - i - 1] = tmp;
        }
        // 再做按对角线翻转
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
