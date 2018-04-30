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
public class CheckBalance {
    volatile boolean isBalanced = true;
    /**
     * 思路：
     * 求这颗树的高度的同时计算出这颗二叉树是否是平衡的
     */
    public boolean check(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return Math.max(left + 1, right + 1);
    }
    
}