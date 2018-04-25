import java.util.*;

public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = A[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                    minIndex = j;
                }
            }
            A[minIndex] = A[i];
            A[i] = min;
        }
        return A;
    }
}