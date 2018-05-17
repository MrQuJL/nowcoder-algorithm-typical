import java.util.*;

/**
 * 题目名称：出现了奇数次的数II
 * 题目描述：给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。
 * 要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
 */
public class OddAppearance {
    public int[] findOdds(int[] arr, int n) {
        // 1.把数组中的数从头到尾异或一遍，得到一个值
        int xor = xorArray(arr, 0, n - 1);
        // 2.得到该值第一个不是0的bit位
        int bit = getPos1(xor);
        // 3.将数组中所有的数按照这一位是不是0分成两份
        int border = divideArr(arr, bit);
        // 4.分别异或每一边即可求出每边的那个出现了奇数次的数
        int left = xorArray(arr, 0, border);
        int right = xorArray(arr, border + 1, n - 1);
        int[] res = new int[2];
        res[0] = right;
        res[1] = left;
        Arrays.sort(res);
        return res;
    }
    
    public int xorArray(int[] arr, int start, int end) {
        int ex = arr[start];
        for (int i = start + 1; i <= end; i++) {
            ex ^= arr[i];
        }
        return ex;
    }
    
    public int getPos1(int num) {
        int pos = 1; // 第1位是个位，第2位是百位
        while (num != 0) {
            int temp = num & 1;
            if (temp == 1) {
                break;
            }
            num = num >> 1;
            pos++;
        }
        return pos;
    }
    
    public int divideArr(int[] arr, int pos1) {
        int[] newArr = new int[arr.length];
        int first = 0;
        int last = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (is1(arr[i], pos1)) { // 这一位是1就放左边
                newArr[first++] = arr[i];
            } else { // 不是1就放右边
                newArr[last--] = arr[i];
            }
        }
        // 拷贝回原数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
        return first - 1;
    }
    
    public boolean is1(int num, int pos1) {
        while (pos1-- > 1) {
            num = num >> 1;
        }
        if ((num & 1) == 0) {
            return true;
        }
        return false;
    }
    
}