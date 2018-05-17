import java.util.*;

/**
 * 题目名称：不用判断做比较
 * 题目描述：对于两个32位整数a和b，请设计一个算法返回a和b中较大的。
 * 但是不能用任何比较判断。若两数相同，返回任意一个。
 * 给定两个整数a和b，请返回较大的数。
 */
public class Compare {
    /**
     * 思路：
     * 得到a-b的符号，根据该符号决定返回a或b
     */
    public int getMax(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }
    
    // n为0则返回1，n为1则返回0
    public int flip(int n) {
        return n ^ 1;
    }
    
    // 取得一个32位整数符号的一个函数，不是负数则返回1，是负数则返回0
    public int sign(int n) {
        return flip((n >> 31) & 1);
    }
    
}