import java.util.*;

/**
 * 题目名称：双栈队列
 * 题目描述：编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，
 * 保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 */
public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
        // 合法性判断
        if (ope == null || n < 1) {
            return ope;
        }
        // 先统计有多少个pop操作
        int countPop = 0;
        for (int i = 0; i < n; i++) {
            if (ope[i] == 0) {
                countPop++;
            }
        }
        // 初始化自定义的队列
        Queue queue = new Queue();
        int[] result = new int[countPop];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (ope[i] > 0) { // push操作
                queue.push(ope[i]);
            } else if (ope[i] == 0) { // pop操作
                result[index++] = queue.pop();
            }
        }
        return result;
    }
}

class Queue {
    LinkedList<Integer> stack1 = new LinkedList<Integer>();
    LinkedList<Integer> stack2 = new LinkedList<Integer>();
    
    public void push(int num) {
        stack1.addFirst(num);
    }
    
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.removeFirst());
            }
        }
        return stack2.removeFirst();
    }
}