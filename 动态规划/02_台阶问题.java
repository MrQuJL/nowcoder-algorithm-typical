import java.util.*;

/**
 * 题目名称：台阶问题练习题
 * 题目描述：
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 * 测试样例：
 * 1
 * 返回：1
 */
public class GoUpstairs {
    public int countWays(int n) {
        // 合法性判断
        if (n < 0) {
            return 0;
        }
        // 一阶台阶的时候返回1
        if (n == 1) {
            return 1;
        }
        // 二阶台阶的时候返回2
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int fib = 0;
        for (int i = 3; i <= n; i++) {
            fib = (first + second) % 1000000007;
            first = second;
            second = fib;
        }
        return fib;
    }
}