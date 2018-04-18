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
 * 题目名称：判断t1中是否有与t2的拓扑结构完全相同的子树
 */
public class IdenticalTree {
    public boolean chkIdentical(TreeNode t1, TreeNode t2) {
        String t1Str = serialByPre(t1);
        String t2Str = serialByPre(t2);
        return t1Str.indexOf(t2Str) != -1;
    }
 
    public String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        } 
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
}