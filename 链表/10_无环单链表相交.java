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
 * 题目名称：无环单链表判相交
 * 题目描述：
 * 现在有两个无环单链表，若两个链表的长度分别为m和n，请设计一个时间复杂度为O(n + m)，
 * 额外空间复杂度为O(1)的算法，判断这两个链表是否相交。
 */
public class CheckIntersect {
    /**
     * 思路：
     * 1.分别求出两条链表的长度，差值为x
     * 2.长的先走x步，然后两个一起走，相交返回即可
     */
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }
        int dif = Math.abs(len1 - len2);
        ListNode pLong, pShort;
        pLong = len1 > len2 ? headA : headB;
        pShort = pLong == headA ? headB : headA;
        while (dif-- > 0) {
            pLong = pLong.next;
        }
        while (pLong != null && pShort != null) {
            if (pLong == pShort) {
                return true;
            }
            pLong = pLong.next;
            pShort = pShort.next;
        }
        return false;
    }
}