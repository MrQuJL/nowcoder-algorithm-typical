import java.util.*;

/**
 * 题目名称：编辑距离
 * 题目描述：对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，
 * 定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。
 * 保证两串长度均小于等于300，且三种代价值均小于等于100。
 * 
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 */
public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        // 1.构建状态矩阵
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        // 从一个空字符串转换成指定位数的字符串只能插入
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i * c0;
        }
        // 从有字符串到无字符串只能是删除
        for (int j = 1; j <= n; j++) {
            dp[j][0] = j * c1;
        }
        /**
         * 其余四种情况：
         * 1.dp[i][j]可能是从dp[i-1][j]+dc这个状态来的
         * 2.dp[i][j]可能是从dp[i][j-1]+ic这个状态来的
         * 3.if A[0..i-1] != B[0..j-1]，则dp[i][j]=dp[i-1][j-1]+rc
         * 4.if A[0..i-1] == B[0..j-1]，则dp[i][j]=dp[i-1][j-1]
         * 从这四种情况中找到一个最小的代价
         */
        for (int i = 1; i <= n; i++) {
            int min = 0;
            for (int j = 1; j <= m; j++) {
                min = Math.min(dp[i-1][j] + c1, dp[i][j-1] + c0);
                if (a[i-1] != b[j-1]) {
                    min = Math.min(min, dp[i-1][j-1] + c2);
                } else {
                    min = Math.min(min, dp[i-1][j-1]);
                }
                dp[i][j] = min;
            }
        }
        return dp[n][m];
    }
}