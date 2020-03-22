/**
 * @author Jiang
 * @date 2020/3/22 14:13
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class Solution47 {

    public int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] result = new int[row][col];
        result[0][0] = grid[0][0];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (i != 0) {
                    result[i][j] = result[i - 1][j] + grid[i][j];
                }
                if (j != 0) {
                    result[i][j] = Math.max(result[i][j], result[i][j - 1] + grid[i][j]);
                }
            }
        }
        return result[row - 1][col - 1];
    }
}
