import java.util.Stack;

/**
 * @author Jiang
 * @date 2020/3/19 14:25
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 */
public class Solution31 {

    /**
     * @param pushed 压入序列
     * @param popped 弹出序列
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i : pushed) {
            stack.add(i);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return j == popped.length;
    }
}
