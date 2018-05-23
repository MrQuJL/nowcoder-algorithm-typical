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
 * 题目名称：单链表相交判断
 * 题目描述：给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？相交的话返回true，不想交的话返回false。
 */
public class ChkIntersection {
    /**
     * 思路：
     * 1.找到两个单链表各自的入环节点
     * 2.如果两个入环节点一个为空一个不为空，说明一个有环一个无环，两链表不可能相加
     * 3.如果两个入环节点都为空，说明两个链表都无环，采用无环链表判相交的方法进行判断
     * 4.如果两个入环节点都不为空，说明两个链表都有环，采用有环链表判相交的方法进行判断
     */
    public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        if (head1 == null || head2 == null) {
            return false;
        }
        // 返回两个有环单链表的如环节点
        ListNode h1 = chkLoop(head1);
        ListNode h2 = chkLoop(head2);
        ListNode cur = h1.next;
        if (h1 == h2) return true;
        while (cur != h1) {
            if (cur == h2) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    
    // 判断一个单链表是否有环
    public ListNode chkLoop(ListNode head) {
        // 合法性判断
        if (head == null) {
            return null;
        }
        // 定义两个快慢指针
        ListNode pSlow = head;
        ListNode pFast = head;
        while (pFast != null && pFast.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pFast == pSlow) { // 有环
                break;
            }
        }
        // 无环
        if (pFast == null || pFast.next == null) {
            return null;
        }
        // 有环
        pFast = head;
        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pFast;
    }
    
}