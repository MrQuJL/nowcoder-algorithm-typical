import java.util.*;

/**
 * 题目名称：栈的反转
 * 题目描述：实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，
 * 而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 */
public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        if (n == 0) {
            return null;
        }
        int node = A[n - 1];
        reverseStack(A, n - 1);
        A[A.length - n] = node;
        return A;
    }
}