import java.util.*;

public class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // 合法性判断
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (numbers == null || numbers.length < 1) {
            return list;
        }
        // 申请一个辅助栈
        int n = numbers.length;
        int[] help = new int[n];
        int i = 0, j = n; // i为数据栈的栈顶元素的位置，j为辅助栈的当前元素的指针
        int cur = 0; // 临时变量保存弹栈元素
        while (i < n) {
            cur = numbers[i++]; // 获取当前元素，并且指针下移
            if (j == n) { // 辅助栈为空
                help[--j] = cur;
            } else if (cur <= help[j]) { // 当前元素小于等于辅助栈栈顶元素
                help[--j] = cur;
            } else if (cur > help[j]) { // 当前元素大于辅助栈栈顶元素
                while (j < n && cur > help[j]) {
                    numbers[--i] = help[j++];
                }
                help[--j] = cur;
            }
        }
        for (int m = n - 1; m >= 0; m--) {
            list.add(help[m]);
        }
        return list;
    }
}