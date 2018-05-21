import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目名称：链表的分化
 * 题目描述：
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，
 * 大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，
 * 使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 */
public class Divide {
    /**
     * 思路：
     * 建立两个头节点来保存链表中小于等于阙值的节点和大于阙值的节点
     */
    public ListNode listDivide(ListNode head, int val) {
        // 合法性判断
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode small = new ListNode(-1);
        ListNode s = small;
        ListNode big = new ListNode(-1);
        ListNode b = big;
        
        ListNode pHead = head;
        while (pHead != null) {
            if (pHead.val <= val) {
                small.next = pHead;
                small = small.next;
            } else {
                big.next = pHead;
                big = big.next;
            }
            pHead = pHead.next;
        }
        
        small.next = b.next;
        big.next = null;
        return s.next;
    }
}