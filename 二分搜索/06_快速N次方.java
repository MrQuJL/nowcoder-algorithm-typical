import java.util.*;

public class QuickPower {
    public int getPower(int k, int N) {
        if (N == 0) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        long sum = 1;
        long k2 = k;
        while (N != 0) {
            if ((N & 1) != 0) { // 判断N的当前这一位是不是0，不是0就把k乘进去
                sum = (sum * k2) % 1000000007;
            }
            N = N >> 1; // 把N右移一位，判断下一位
            if (N == 0) break; // N == 0时，退出循环
            k2 = (k2 * k2)% 1000000007; // 累乘k2
        }
        return (int) sum;
    }
}