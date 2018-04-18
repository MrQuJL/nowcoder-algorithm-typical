public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // 合法性判断
        if (m < 1 || A == null || A.length == 0) {
            return 0;
        }
        // 1.构建状态矩阵
        int[][] dp = new int[A.length + 1][m + 1];
        
        // 2.状态转移方程
        // dp[i][j] = Max{dp[i-1][j], dp[i-1][j-w[i-1]]+w[i-1]}
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= A[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]] + A[i-1]);
                }
            }
        }
        return dp[A.length][m];
    }
}