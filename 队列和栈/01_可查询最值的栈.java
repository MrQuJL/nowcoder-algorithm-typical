import java.util.*;

public class Solution {
    LinkedList<Integer> dataStack = new LinkedList<Integer>();
    LinkedList<Integer> minStack = new LinkedList<Integer>();
    
    public void push(int node) {
        dataStack.addFirst(node);
        if (minStack.isEmpty()) {
            minStack.addFirst(node);
        } else {
            minStack.addFirst(minStack.getFirst() > node ? node : minStack.getFirst());
        }
    }
    
    public void pop() {
        if (!dataStack.isEmpty() && !minStack.isEmpty()) {
            dataStack.removeFirst();
            minStack.removeFirst();
        }
    }
    
    public int top() {
        return dataStack.getFirst();
    }
    
    public int min() {
        return minStack.getFirst();
    }
}