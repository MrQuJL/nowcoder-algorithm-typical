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
public class TreeToSequence {
    public int[][] convert(TreeNode root) {
        int[][] result = new int[3][];
        List<Integer> preList = preOrderTraversal(root);
        List<Integer> inList = inOrderTraversal(root);
        List<Integer> postList = postOrderTraversal(root);
        
        int[] preArray = new int[preList.size()];
        for (int i = 0; i < preArray.length; i++) {
            preArray[i] = preList.get(i);
        }
        result[0] = preArray;
        
        int[] inArray = new int[inList.size()];
        for (int i = 0; i < inArray.length; i++) {
            inArray[i] = inList.get(i);
        }
        result[1] = inArray;
        
        int[] postArray = new int[postList.size()];
        for (int i = 0; i < postArray.length; i++) {
            postArray[i] = postList.get(i);
        }
        result[2] = postArray;
        
        return result;
    }
    
    /**
     * 先序非递归
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pHead = root;
        TreeNode temp = null;
        while (!stack.isEmpty() || pHead != null) {
            if (pHead != null) {
                list.add(pHead.val);
                stack.addFirst(pHead);
                pHead = pHead.left;
            } else {
                temp = stack.removeFirst();
                pHead = temp.right;
            }
        }
        return list;
    }
    
    /**
     * 中序非递归
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pHead = root;
        TreeNode temp = null;
        while (!stack.isEmpty() || pHead != null) {
            if (pHead != null) {
                stack.addFirst(pHead);
                pHead = pHead.left;
            } else {
                temp = stack.removeFirst();
                list.add(temp.val);
                pHead = temp.right;
            }
        }
        return list;
    }
    
    /**
     * 后序非递归
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = null;
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            cur = stack.getFirst();
            if ((cur.left == null && cur.right == null) ||
               (pre != null && (cur.left == pre || cur.right == pre))) {
                list.add(stack.removeFirst().val);
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.addFirst(cur.right);
                }
                if (cur.left != null) {
                    stack.addFirst(cur.left);
                }
            }
        }
        return list;
    }
    
}