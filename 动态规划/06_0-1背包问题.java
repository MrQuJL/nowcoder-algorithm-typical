import java.util.*;

public class Backpack {
    public int maxValue(int[] w, int[] v, int n, int cap) {
        // 合法性判断
        if (w == null || v == null || n < 1 || cap < 1) {
            return 0;
        }
        // 构建状态矩阵，行表示物品的数量，列表示背包的最大承重
        // dp[i][j]的值分两种情况：
        // 1.不选当前物品的价值
        // 2.选当前物品（必定要使包能盛放下当前物品的重量）的价值
        int[][] dp = new int[n + 1][cap + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                // dp[i][j] = Max{dp[i-1][j],dp[i-1][j-w[i-1]]+v[i-1]}
                dp[i][j] = dp[i - 1][j];
                if (j - w[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        return dp[n][cap];
    }
}