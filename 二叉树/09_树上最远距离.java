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
 * 题目名称： 树上最远距离
 * 题目描述：从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，
 * 路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，求整棵树上节点间的最大距离。
 * 给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.
 */
public class LongestDistance {
    public int findLongest(TreeNode root) {
        int[] record = new int[1];
        return process(root, record);
    }
    public int process(TreeNode root, int[]record){
        if(root == null){
            record[0] = 0;
            return 0;
        }
        int lmax = process(root.left, record); // 左子树上的最大距离
        int maxfromleft = record[0]; // 左子树上距离root左孩子最远距离
        int rmax = process(root.right, record);
        int maxfromright = record[0];
        int cur = maxfromleft + maxfromright + 1; // 跨左右孩子的最大距离
        
        record[0] = Math.max(maxfromleft, maxfromright) + 1; // 记录一边最大的距离
        
        return Math.max(Math.max(lmax, rmax), cur); // 单独一侧的距离长还是两侧加起来的距离长
    }
}