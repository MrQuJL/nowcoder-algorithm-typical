import java.util.*;

public class Subsequence {
    /**
     * 思路：
     * 1.从左向右遍历数组，记录最大值大于当前值的最右的位置
     * 2.从右向左便来数组，记录最小值小于当前值的最左的位置
     */
    public int shortestSubsequence(int[] A, int n) {
        int max = Integer.MIN_VALUE;
        int maxPos = 0;
        int min = Integer.MAX_VALUE;
        int minPos = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            maxPos = max > A[i] ? i : maxPos;
        }
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, A[i]);
            minPos = min < A[i] ? i : minPos;
        }
        
        return maxPos == minPos ? maxPos - minPos : maxPos - minPos + 1;
    }
}