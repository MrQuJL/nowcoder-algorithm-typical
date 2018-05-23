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
 * 题目名称：链表判环
 * 题目描述：
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，请返回所求值。
 */
public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
        // 合法性判断
        if (head == null) {
            return -1;
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
            return -1;
        }
        // 有环
        pFast = head;
        while (pFast != pSlow) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }
        return pFast.val;
    }
}