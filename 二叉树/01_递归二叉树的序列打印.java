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
        List<Integer> preList = new ArrayList<Integer>();
        List<Integer> inList = new ArrayList<Integer>();
        List<Integer> postList = new ArrayList<Integer>();
        
        preOrderTraversal(root, preList);
        int[] preArray = new int[preList.size()];
        for (int i = 0; i < preArray.length; i++) {
            preArray[i] = preList.get(i);
        }
        result[0] = preArray;
        
        inOrderTraversal(root, inList);
        int[] inArray = new int[inList.size()];
        for (int i = 0; i < inArray.length; i++) {
            inArray[i] = inList.get(i);
        }
        result[1] = inArray;
        
        postOrderTraversal(root, postList);
        int[] postArray = new int[postList.size()];
        for (int i = 0; i < postArray.length; i++) {
            postArray[i] = postList.get(i);
        }
        result[2] = postArray;
        
        return result;
    }
    
    public void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }
    
    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
        }
    }
    
    public void postOrderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            postOrderTraversal(root.left, list);
            postOrderTraversal(root.right, list);
            list.add(root.val);
        }
    }
    
}