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
 * 题目名称：访问单个节点的删除
 * 题目描述：实现一个算法，删除单向链表中间的某个结点，假定你只能访问该结点。
 * 给定带删除的头节点和要删除的数字，请执行删除操作，返回删除后的头结点。链表中没有重复数字
 */
public class Remove {
    /**
     * 思路：
     * 将当前节点的值用后一个节点的值覆盖
     * 当前节点的next域指向它的next的next节点
     * 这种思路可能出现的问题：最后一个节点无法删除，此算法仅提供一个思路，一般不用于实际工程
     */
    public ListNode removeNode(ListNode pNode, int delVal) {
        // 合法性判断
        if (pNode == null || pNode.next == null) {
            return null;
        }
        if (pNode.val == delVal) {
            return pNode.next;
        }
        ListNode pre = pNode;
        ListNode cur = pNode.next;
        while (pre != null && cur != null) {
            if (cur.val == delVal) {
                pre.next = cur.next;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return pNode;
    }
}