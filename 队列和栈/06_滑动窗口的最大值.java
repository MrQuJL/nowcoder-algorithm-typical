import java.util.*;

/**
 * 题目名称：滑动窗口的最大值
 * 题目描述：有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。 以数组为[4,3,5,4,3,3,6,7]，w=3为例。
 * 因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4,3]的最大值为5。
 * 第四个窗口[4,3,3]的最大值为4。第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。
 * 所以最终返回[5,5,5,4,6,7]。
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。
 */
public class SlideWindow {
    public int[] slide(int[] arr, int n, int w) {
        // 合法性判断
        if (arr == null || n < 1 || w < 1) {
            return null;
        }
        int left = 0;
        int[] max = new int[n - w + 1];
        int index = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(w, Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            maxHeap.offer(arr[i]);
            if (maxHeap.size() == w) {
                max[index++] = maxHeap.peek();
                maxHeap.remove(arr[left++]);
            }
        }
        return max;
    }
}