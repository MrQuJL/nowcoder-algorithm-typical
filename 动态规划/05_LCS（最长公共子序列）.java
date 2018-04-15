import java.util.*;

public class LCS {
    /**
     * 思路：
     * 1.生成大小为n*m的矩阵dp
     * 2.dp[i][j]的含义是A[0..i]与A[0..j]的最长公共子序列的长度
     * dp求法如下：
     * 1.矩阵dp第一列，即dp[i][0]，代表A[0..i]与B[0]的最长公共子序列长度。
     *   B[0]只有一个字符，所以dp[i][0]最大为1。
     *   如果A[i] == B[0]，则另dp[i][0]=1
     *   一旦dp[i][0]被设为1，则另dp[i+1..n][0]全部为1
     * 2.矩阵dp第一行，即dp[0][j]，与步骤1同理。
     *   如果A[0] == B[j]，则令dp[0][j]=1
     *   一旦dp[0][j]被设为1，则令dp[0][j+1..m]全部为1
     * 3.其他位置，dp[i][j]的值只可能来自以下三种情况：
     *   情况一：可能是dp[i][j-1]的值，这代表A[0..i]与B[0..j-1]的最长公共子序列的长度。
     *   这代表B的最后一个字符加与不加都不影响最后的公共子序列的长度。
     *   情况二：可能是dp[i-1][j]的值，这代表A[0..i-1]与B[0..j]的最长公共子序列的长度。
     *   这代表A的最后一个字符加与不加都不影响最后的公共子序列的长度。
     *   情况三：可能是dp[i-1][j-1]的值+1，这代表A[0..i-1]与B[0..j-1]的最长公共子序列的长度+1。
     *   这种情况就是A[i]==A[j]时，dp[i][j]就是两个字符串都减去最后一个字符的最长公共子序列的长度+1.
     *   三种可能的值中，选最大的值作为dp[i][j]的值。
     */
    public int findLCS(String A, int n, String B, int m) {
        // 合法性判断
        if (A == null || B == null || A.length() == 0 || B.length() == 0 || n < 0 || m < 0) {
            return 0;
        }
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        // 1.构建状态矩阵
        int[][] dp = new int[n+1][m+1];
        // 2.求出第一列的值
        /*for (int i = 0; i < n; i++) {
            if (A.substring(i, i + 1).equals(B.substring(0, 1))) {
                dp[i][0] = 1;
            }
        }
        // 3.求出第一行的值
        for (int j = 0; j < m; j++) {
            if (A.substring(0, 1).equals(B.substring(j, j + 1))) {
                dp[0][j] = 1;
            }
        }*/
        // 4.求出其他三种情况的值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
}