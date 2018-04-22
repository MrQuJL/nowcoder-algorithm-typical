import java.util.*;

/**
 * 题目名称：循环有序数组的最小值
 * 题目描述：对于一个有序循环数组arr，返回arr中的最小值。
 * 有序循环数组是指，有序数组左边任意长度的部分放到右边去，右边的部分拿到左边来。
 * 比如数组[1,2,3,3,4]，是有序循环数组，[4,1,2,3,3]也是。
 * 给定数组arr及它的大小n，请返回最小值。
 */
public class MinValue {
    /**
     * 思路：
     * 1.合法性判断
     * 2.设在范围内最左边的数的下标为l,右边的数的下标为r，中间的数的下标为m
     * 3.如果arr[m] < arr[r]，最小的数一定在左边
     * 4.如果arr[m] > arr[r]，最小的数一定在右边
     * 5.如果arr[m] == arr[r]，只能一个一个判断
     */
    public int getMin(int[] arr, int n) {
        // 1.合法性判断
        if (arr == null || arr.length == 0 || n < 1) {
            return -1;
        }
        // 2.设在范围内最左边的数的下标为l,右边的数的下标为r，中间的数的下标为m
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) { // 中间的数大于最右边的数，则最小的数在右边
                left = mid + 1;
            } else if (arr[mid] < arr[right]) { // 中间的数在左边（包括了当前的mid）
                right = mid;
            } else { // 只能一个一个缩小范围
                right = right - 1;
            }
        }
        return arr[left];
    }
}