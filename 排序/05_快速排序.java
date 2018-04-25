import java.util.*;

public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        quick(A, 0, n - 1);
        return A;
    }
    
    public void quick(int[] A, int low, int high) {
        if (low < high) {
            int middle = partition(A, low, high);
            quick(A, low, middle - 1);
            quick(A, middle + 1, high);
        }
    }
    
    public int partition(int[] A, int low, int high) {
        int pivot = A[low];
        while (low < high) {
            while (low < high && A[high] >= pivot) {
                high--;
            }
            A[low] = A[high];
            while (low < high && A[low] <= pivot) {
                low++;
            }
            A[high] = A[low];
        }
        A[low] = pivot;
        return low;
    }
    
}