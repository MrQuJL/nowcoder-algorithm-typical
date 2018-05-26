import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
/**
 * 题目名称：寻找错误结点
 * 题目描述：一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，
 * 请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。
 * 给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。
 */
public class FindErrorNode {
    /**
     * 思路：
     * 第一个错误的节点为第一次降序时节点值较大的节点
     * 第二个错误的节点为最后一次降序时节点值较小的节点
     */
    public int[] findError(TreeNode root) {
        int[] arr = new int[2];
        arr[0] = Integer.MAX_VALUE;
        arr[1] = Integer.MIN_VALUE;
        dfs(root, arr);
        return arr;
    }
    //此题目仍旧是相当于把中序遍历进行改造
    private void dfs(TreeNode root, int[] arr) {
       if(root == null) return;
       dfs(root.left, arr);
       if(root.val < arr[1]) {
           //此时arr[1]不应该再进行更新了，转而应该去尝试更新arr[0]的值
           arr[0] = Math.min(arr[0], root.val);
       }
       else if(arr[0] == Integer.MAX_VALUE) {
           arr[1] = root.val;
       }
        dfs(root.right, arr);
    }
}