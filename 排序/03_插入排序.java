import java.util.*;

public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        for (int i = 1; i < n; i++) {
            int temp = A[i];
            int j;
            for (j = i - 1; j >= 0 && A[j] > temp; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = temp;
        }
        return A;
    }
}