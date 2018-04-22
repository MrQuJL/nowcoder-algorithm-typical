import java.util.*;

/**
 * 题目名称：最左原位
 * 题目描述：有一个有序数组arr，其中不含有重复元素，请找到满足arr[i]==i条件的最左的位置。
 * 如果所有位置上的数都不满足条件，返回-1。
 * 给定有序数组arr及它的大小n，请返回所求值。
 */
public class Find {
    /**
     * 思路：
     * 假设最左边的数的下标为left，最右边的数的下标为right，中间的数的下标为mid
     * 1.合法性判断：如果arr[0] > right
     * 如果arr[right] < 0 均返回-1
     * 2.看中间的数，如果arr[mid] > mid,right = mid - 1
     * 如果arr[mid] < mid,left = mid + 1
     * 如果arr[mid] = mid，记录下来，缩小为左边的范围继续二分
     */
    public int findPos(int[] arr, int n) {
        int res = -1;
        // 1.合法性判断
        if (arr[0] > n - 1 || arr[n - 1] < 0) {
            return res;
        }
        // 2.看中间的数
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == mid) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}