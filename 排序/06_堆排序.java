import java.util.*;

public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        // 合法性判断
        if (A == null || A.length < 1 || n < 1) {
            return null;
        }
        for (int i = 0; i < n - 1; i++) {
            // 建堆
            buildMaxHeap(A, n - 1 - i);
            // 交换堆顶元素和最后一个元素
            swap(A, 0, n - 1 - i);
        }
        return A;
    }
    
    public void buildMaxHeap(int[] A, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i > -1; i--) {
            int k = i;
            while (k * 2 + 1 <= lastIndex) { // 说明有左子节点，但不一定有右子节点
                int biggerIndex = k * 2 + 1;
                if (k * 2 + 1 < lastIndex) { // 说明有右子节点
                    if (A[biggerIndex] < A[biggerIndex + 1]) { // 记录子节点中最大的那个节点
                        biggerIndex++;
                    }
                }
                if (A[k] < A[biggerIndex]) { // 子节点的值大于父节点的值
                    swap(A, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }
    
    public void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
    
}