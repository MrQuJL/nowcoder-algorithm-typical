import java.util.*;

/**
 * 题目名称：栈的逆序
 * 题目描述：实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，
 * 而不能自己申请另外的数据结构。
 * 这次不是使用数组，而是使用真实的栈Stack
 */
public class StackReverse {
	/**
	 * 实现整个栈逆序的方法
	 */
    public void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int bottom = getBottom(stack); // 拿到栈底元素
		reverseStack(stack); // 拿到第二层
		stack.push(bottom);
    }

	/**
	 * 移除栈底元素并返回
	 */
	 public int getBottom(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getBottom(stack);
			stack.push(result);
			return last;
		}
	 }
}



