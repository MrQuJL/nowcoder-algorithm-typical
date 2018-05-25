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
    public boolean isBalanced = true;
    public boolean check(TreeNode root) {
        getLen(root);
        return isBalanced;
    }
    
    public int getLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getLen(root.left);
        int right = getLen(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return left > right ? left + 1 : right + 1;
    }
    
}