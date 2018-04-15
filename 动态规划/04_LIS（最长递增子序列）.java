import java.util.*;

public class LongestIncreasingSubsequence {
    /**
     * 思路：
     * 1.生成长度为n的dp数组
     * 2.dp[i]表示必须以A[i]这个数结尾的情况下，A[0..i]中最大的递增子序列的长度
     * 3.状态转移方程为：dp[i] = Max{dp[j] + 1(0 <= j < i,A[j] < A[i])}
     */
    public int getLIS(int[] A, int n) {
        // 合法性判断
        if (A == null || A.length == 0 || n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }
        int maxLength = dp[0]; // 记录最长的公共子序列的长度
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    // 记录i之前的数字所组成的最大公共子序列的长度
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}