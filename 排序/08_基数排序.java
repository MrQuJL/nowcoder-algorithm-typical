import java.util.*;

public class RadixSort {
    public int[] radixSort(int[] A, int n) {
        if (A == null || n < 2) {
            return A;
        }
        // 获得最大的数，确定要分配的次数
        int max = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        // 确定要分配的次数
        int times = 0;
        while (max > 0) {
            times++;
            max /= 10;
        }
        // 建立10个队列
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            bucket.add(list);
        }
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < n; j++) {
                // 取第i+1位上的数字
                int x = A[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> queue2 = bucket.get(x);
                queue2.add(A[j]);
            }
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (bucket.get(j).size() > 0) {
                    A[count++] = bucket.get(j).get(0);
                    bucket.get(j).remove(0);
                }
            }
        }
        return A;
    }
}