import java.util.*;

/**
 * 题目名称：找零钱
 * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 */
public class Exchange {
    public int countWays(int[] penny, int n, int aim) {
        if (penny == null || penny.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[penny.length + 1][aim + 1];
        return process1(penny, 0, aim, map);
    }
    
    public int process1(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * arr[index] <= aim; i++) {
                int mapValue = 0;
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process1(arr, index + 1, aim - i * arr[index], map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }
    
}