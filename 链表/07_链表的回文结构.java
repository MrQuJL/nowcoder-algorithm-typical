import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Palindrome {
    /**
     * 思路：
     * 1.遍历单链表把每个节点压入栈中，再遍历一遍单链表栈中的节点依次弹出，
     * 并与遍历到的节点比对，不同则返回false，都相同则返回true
     */
    public boolean isPalindrome(ListNode pHead) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode pTemp1 = pHead;
        ListNode pTemp2 = pHead;
        while (pTemp1 != null) {
            stack.push(pTemp1);
            pTemp1 = pTemp1.next;
        }
        while (pTemp2 != null && !stack.isEmpty()) {
            ListNode peek = stack.pop();
            if (pTemp2.val != peek.val) {
                return false;
            }
            pTemp2 = pTemp2.next;
        }
        return true;
    }
}