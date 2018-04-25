import java.util.*;

public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
        if (A == null || A.length == 0 || n < 1) {
            return A;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
        return A;
    }
}