import java.util.*;

/**
 * 题目名称：重复值判断
 * 题目描述：请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
 * 注：此题因为空间复杂度为O(1)，所以要使用堆排序，这里使用快速排序只是为了练习...
 */
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        // 先排序，然后贴在一起的相同的元素就是重复的
        // 堆排序上一个已经练习过了，所以这里练习一下快速排序
        quickSort(a, 0, n - 1);
        for (int i = 0; i < n -1 ; i++) {
            if (a[i] == a[i + 1]) {
                return true;
            }
        }
        return false;
    }
    
    public void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int middle = partition(a, low, high);
            quickSort(a, low, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }
    
    public int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivot) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivot) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }
    
}