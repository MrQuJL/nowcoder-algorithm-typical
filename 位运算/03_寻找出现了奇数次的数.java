import java.util.*;

/**
 * 题目名称：寻找奇数出现
 * 题目描述：有一个整型数组A，其中只有一个数出现了奇数次，其他的数都出现了偶数次，请打印这个数。
 * 要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定整形数组A及它的大小n，请返回题目所求数字。
 */
public class OddAppearance {
    /**
     * 思路：
     * 一个数异或它自己结果为0,
     * 数组中所有的数从头到尾异或一遍就可以获得那个出现了奇数次的数
     * n与0异或结果为n
	 * n与n异或结果为0
	 */
    public int findOdd(int[] A, int n) {
        int res = A[0];
        for (int i = 1; i < n; i++) {
            res = res ^ A[i];
        }
        return res;
    }
}