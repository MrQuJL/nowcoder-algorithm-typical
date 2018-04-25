import java.util.*;

public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        divideArray(A, 0, n - 1);
        return A;
    }
    
    public void divideArray(int[] A, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2; // 防止溢出
            divideArray(A, left, middle);
            divideArray(A, middle + 1, right);
            merge(A, left, middle, right);
        }
    }
    
    public void merge(int[] A, int left, int middle, int right) {
        int[] tempArr = new int[A.length];
        int mid = middle + 1;
        int temp = left;
        int index = left;
        while (left <= middle && mid <= right) {
            if (A[left] <= A[mid]) {
                tempArr[temp++] = A[left++];
            } else {
                tempArr[temp++] = A[mid++];
            }
        }
        while (left <= middle) {
            tempArr[temp++] = A[left++];
        }
        while (mid <= right) {
            tempArr[temp++] = A[mid++];
        }
        while (index <= right) {
            A[index] = tempArr[index++];
        }
    }
    
}