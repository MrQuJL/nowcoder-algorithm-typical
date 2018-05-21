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
 * 题目名称：环形链表插值
 * 题目描述：
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 */
public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        ListNode ins = new ListNode(val);
        // 合法性判断，只有一个节点的情况
        if (A == null || nxt == null) {
            ins.next = ins;
            return ins;
        }
        
        // 1.构造出环形链表
        ListNode head = new ListNode(A[0]);
        ListNode tail = head;
        for (int i = 0; i < nxt.length - 1; i++) {
            ListNode node = new ListNode(A[nxt[i]]);
            tail.next = node;
            tail = node;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        
        // 2.向链表中插值
        while (pre != null && cur != null) {
            if (val >= pre.val && val <= cur.val) {
                ins.next = cur;
                pre.next = ins;
                return head;
            }
            pre = pre.next;
            cur = cur.next;
        }
        if (val <= head.val) {
            ins.next = head;
            return ins;
        } else {
            tail.next = ins;
        }
        
        return head;
    }
}