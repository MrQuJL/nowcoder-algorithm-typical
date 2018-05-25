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
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode temp = null;
        boolean isComplete = true;
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            temp = queue.removeLast();
            
            // 如果当前节点有右孩子没有左孩子，直接返回false
            if (temp.right != null && temp.left == null) {
                return false;
            } else if (temp.left != null && temp.right == null) {
                queue.addFirst(temp.left);
                isComplete =  false;
                continue;
            }
            
            if (!isComplete && (temp.left != null || temp.right != null)) {
                return false;
            }
            
            if (temp.left != null) {
                queue.addFirst(temp.left);
            }
            if (temp.right != null) {
                queue.addFirst(temp.right);
            }
        }
        return true;
    }
}