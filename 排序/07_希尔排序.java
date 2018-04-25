import java.util.*;

public class ShellSort {
    public int[] shellSort(int[] A, int n) {
        if (A == null || n < 1) {
            return A;
        }
        while (true) {
            n /= 2;
            for (int x = 0; x < n; x++) {
                for (int i = x + n; i < A.length; i = i + n) {
                    int temp = A[i];
                    int j;
                    for (j = i - n; j >= 0 && A[j] > temp; j = j - n) {
                        A[j + n] = A[j];
                    }
                    A[j + n] = temp;
                }
            }
            if (n == 1) {
                break;
            }
        }
        return A;
    }
}