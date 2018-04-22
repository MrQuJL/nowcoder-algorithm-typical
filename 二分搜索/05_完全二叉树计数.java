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
 * 题目名称：完全二叉树计数
 * 题目描述：给定一棵完全二叉树的根节点root，返回这棵树的节点个数。
 * 如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
 * 给定树的根结点root，请返回树的大小。
 */
public class CountNodes {
    /**
     * 思路：
     * 1.合法性判断，非空
     * 2.找到完全二叉树的最左边的节点以确定完全二叉树的高度leftH
     * 3.找到完全二叉树的右子树的最左节点以确定右子树的高度rightH
     * 4.如果rightH = leftH，说明左子树是一颗满二叉树，通过公式可得左子树的节点个数
     * 5.若果rightH < leftH，说明右子树是一颗满二叉树，通过公式可得右子树的节点个数
     * 6.递归求得剩余部分
     */
    public int count(TreeNode root) {
        // 1.合法性判断，非空
        if (root == null) {
            return 0;
        }
        // 2.找到完全二叉树的最左边的节点以确定完全二叉树的高度leftH
        TreeNode pLeft = root;
        int leftH = 0;
        while (pLeft.left != null) {
            leftH++;
            pLeft = pLeft.left;
        }
        // 3.找到完全二叉树的右子树的最左节点以确定右子树的高度rightH
        TreeNode pRight = root;
        int rightH = 0;
        if (pRight.right != null) {
            pRight = pRight.right;
            rightH++;
            while (pRight.left != null) {
                rightH++;
                pRight = pRight.left;
            }
        }
        // 4.如果rightH = leftH，说明左子树是一颗满二叉树，通过公式可得左子树的节点个数
        int totalLeft = 0;
        int totalRight = 0;
        if (leftH == rightH) {
            totalLeft = (int) Math.pow(2, leftH) - 1;
            totalRight = count(root.right);
        } else if (rightH < leftH) {
            // 5.若果rightH < leftH，说明右子树是一颗满二叉树，通过公式可得右子树的节点个数
            totalRight = (int) Math.pow(2, rightH) - 1;
            totalLeft = count(root.left);
        }
        return totalLeft + totalRight + 1;
    }
}