import java.util.*;

/**
 * 题目名称：双栈排序
 * 题目描述：请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，
 * 但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
 * 请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 */
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