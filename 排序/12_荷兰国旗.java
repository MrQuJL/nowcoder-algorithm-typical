import java.util.*;

/**
 * 题目名称：三色排序（荷兰国旗）
 * 题目描述：有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。
 * 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 */
public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        int index0 = 0;
        int index2 = n - 1;
        int index = 0;
        
        while (index <= index2) {
            if (A[index] == 0) { // 放到0区域中
                swap(A, index0++, index++);
            } else if (A[index] == 1) {
                index++;
            } else if (A[index] == 2) {
                swap(A, index2--, index);
            }
        }
        
        return A;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
}