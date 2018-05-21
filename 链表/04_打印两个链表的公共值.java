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
 * 题目名称：打印两个链表的公共值
 * 题目描述：
 * 现有两个升序链表，且链表中均无重复元素。请设计一个高效的算法，打印两个链表的公共值部分。
 * 给定两个链表的头指针headA和headB，请返回一个vector，元素为两个链表的公共部分。
 * 请保证返回数组的升序。两个链表的元素个数均小于等于500。保证一定有公共值
 * 测试样例：
 * {1,2,3,4,5,6,7},{2,4,6,8,10}
 * 返回：[2.4.6]
 */
public class Common {
    /**
     * 思路：
     * 定义两个指针分别指向两个链表的头节点，相等则同时后移，否则小的那个后移，直至一个指针指向空
     */
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        int count = 0; // 统计公共值的个数
        ArrayList<Integer> res = new ArrayList<Integer>();
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                res.add(p1.val);
                p1 = p1.next;
                p2 = p2.next;
                count++;
            } else if (p1.val < p2.val) {
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
        }
        int[] list = new int[count];
        for (int i = 0; i < count; i++) {
            list[i] = res.get(i);
        }
        return list;
    }
}