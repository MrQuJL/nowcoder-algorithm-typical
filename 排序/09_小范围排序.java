import java.util.*;

public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        // 循环建堆交换堆顶和最后一个元素
        /*for (int i = 0; i < n - 1; i++) {
            // 建堆
            buildMaxHeap(A, n - 1 - i);
            // 交换堆顶和数组中最后一个元素
            swap(A, 0, n - 1 - i);
        }*/
        
        // 使用优先级队列，默认实现小根堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        int[] result = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(A[i]);
            } else {
                result[index++] = minHeap.poll();
                minHeap.offer(A[i]);
            }
        }
        while (minHeap.size() > 0) {
            result[index++] = minHeap.poll();
        }
        
        return result;
    }
    
    public void buildMaxHeap(int[] A, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (k * 2 + 1 <= lastIndex) { // 有孩子节点
                int biggerIndex = k * 2 + 1; // biggerIndex记录左右孩子中最大的那个节点的下标
                if (biggerIndex < lastIndex) { // 有右孩子
                    if (A[biggerIndex] < A[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
                // 判断左右孩子节点中最大的那个节点与父节点哪个大
                if (A[k] < A[biggerIndex]) {
                    swap(A, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
}