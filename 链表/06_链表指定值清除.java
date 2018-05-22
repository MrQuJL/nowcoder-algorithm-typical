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
 * 题目名称：链表指定值清除
 * 题目描述：现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，保证链表中有不等于该值的其它值。
 * 请保证其他元素的相对顺序。
 */
public class ClearValue {
    /**
     * 思路：
     * 把删除的过程看成是一个构造新链表的过程即可
     */
    public ListNode clear(ListNode head, int val) {
        // 合法性判断
        if (head == null) {
            return head;
        }
        ListNode pReturn = new ListNode(-1);
        ListNode pHead = pReturn;
        while (head != null) {
            if (head.val != val) { // 不是待删除节点
                pHead.next = head;
                pHead = head;
            }
            head = head.next;
        }
        return pReturn.next;
    }
}