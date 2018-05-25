import java.util.*;

public class FoldPaper {
    // 折痕所形成的形状为一颗二叉树
    // 根节点为下折痕，此后右子树的根节点都为下折痕，左子树的根节点都为上折痕
    public String[] foldPaper(int n) {
        List<String> list = new ArrayList<String>();
        postOrder(1, n, true, list);
        String[] str = new String[list.size()];
        for (int i = 0; i < str.length; i++) {
            str[i] = list.get(i);
        }
        return str;
    }
    
    public void postOrder(int i, int n, boolean down, List<String> list) {
        if (i > n) {
            return;
        }
        postOrder(i + 1, n, true, list);
        list.add(down ? "down" : "up");
        postOrder(i + 1, n, false, list);
    }
    
    
}