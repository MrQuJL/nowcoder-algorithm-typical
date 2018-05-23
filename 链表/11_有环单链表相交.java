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
 * 题目名称：有环单链表相交
 * 题目描述：如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不想交的话返回空。
 * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
 */
public class ChkIntersection {
    /**
     * 思路：
     * 分别求出两个有环单链表的入环节点
     * 如果入环节点相同则两链表相交
     * 不同则在环中进行遍历，遍历的过程中找到第二个链表的入环节点则相交
     * 遍历到起点也没有找到，则不相交
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