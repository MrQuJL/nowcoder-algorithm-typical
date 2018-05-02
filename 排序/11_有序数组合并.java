import java.util.*;

public class Merge {
    /**
     * 思路：
     * 从A的末尾处开始填充
     */
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        int index = n + m - 1;
        int i = n - 1;
        int j = m - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
        return A;
    }
}