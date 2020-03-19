import java.util.PriorityQueue;

/**
 * @author Jiang
 * @date 2020/3/19 10:55
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 */
public class Solution40 {

    public int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0) {
            return new int[0];
        }

        // 最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((x1, x2) -> {
            return x2 - x1;
        });

        for (int i = 0; i < arr.length; ++i) {
            if (queue.size() < k) {
                queue.add(arr[i]);
            } else if (queue.peek() > arr[i]) {
                queue.poll();
                queue.add(arr[i]);
            }
        }

        Integer[] tmp = new Integer[queue.size()];
        queue.toArray(tmp);
        int[] result = new int[tmp.length];
        for (int i = 0; i < tmp.length; ++i) {
            result[i] = tmp[i];
        }

        return result;
    }
}
