import java.util.*;

/**
 * 题目名称：拼接最小字典序
 * 题目描述：对于一个给定的字符串数组，请找到一种拼接顺序，
 * 使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。
 */
public class Prior {
    /**
     * 思路：
     * 利用比较器，实现Comparator接口，复写compare方法
     */
    public class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s1 + s2).compareTo(s2 + s1);
        }
    }
    
    public String findSmallest(String[] strs, int n) {
        // 合法性判断
        if (strs == null || strs.length == 0 || n < 1) {
            return null;
        }
        Arrays.sort(strs, new MyComparator());
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            buffer.append(strs[i]);
        }
        return buffer.toString();
    }
}
