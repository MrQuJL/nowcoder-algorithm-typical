import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
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