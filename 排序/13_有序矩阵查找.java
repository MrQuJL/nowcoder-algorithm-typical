import java.util.*;

public class Finder {
    /**
     * 思路：
     * 1.从矩阵的右上角开始比较
     * 2.如果比右上角的值大，就剔除一行
     * 3.如果比右上角的值小，就剔除一列
     * 4.相等则返回
     */
    public boolean findX(int[][] mat, int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            } else if (mat[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}