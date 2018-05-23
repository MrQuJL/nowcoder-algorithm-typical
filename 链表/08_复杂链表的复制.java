/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;
    RandomListNode(int label) {
        this.label = label;
    }
}
*/
/**
 * 题目名称：复杂链表的复制
 * 题目描述：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        // 合法性判断
        if (pHead == null) {
            return pHead;
        }
        // 1.在每个节点后面追加一个其自身的拷贝
        cloneNodes(pHead);
        // 2.将每个拷贝节点的random域修改为它原节点的random域的next
        linkRandom(pHead);
        // 3.分离两条链表
        RandomListNode pReturn = separateList(pHead);
        return pReturn;
    }
    
    // 1.在每个节点后面追加一个其自身的拷贝
    public void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode temp = new RandomListNode(pNode.label);
            temp.next = pNode.next;
            pNode.next = temp;
            pNode = pNode.next.next;
        }
    }
    
    // 2.将每个拷贝节点的random域修改为它原节点的random域的next
    public void linkRandom(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null && pNode.next != null) {
            if (pNode.random != null) {
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }
    }
    
    // 3.分离两条链表
    public RandomListNode separateList(RandomListNode pHead) {
        RandomListNode trick = new RandomListNode(-1);
        RandomListNode pReturn = trick;
        RandomListNode pNode = pHead;
        while (pNode != null && pNode.next != null) {
            trick.next = pNode.next;
            trick = trick.next;
            pNode.next = trick.next;
            pNode = pNode.next;
        }
        return pReturn.next;
    }
    
}