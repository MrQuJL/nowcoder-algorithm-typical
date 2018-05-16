import java.util.*;

/**
 * 题目名称：最长无重复字符子串的长度
 * 题目描述：
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 */
public class DistinctSubstring {
    /**
     * 思路：
     * 求出以A中每个字符结尾的情况下，最长无重复字符子串的长度
     * 并记录其中的最大值，最后返回。
     */
    public int longestSubstring(String A, int n) {
        if (A == null || n < 1) {
            return 0;
        }
        
        char[] ch = A.toCharArray();
        int[] map = new int[256]; // 哈希表统计每种字符之前出现的位置
        Arrays.fill(map, -1);
        int len = 0; // 最长无重复字符子串的长度
        int pre = -1; // 当前字符上一次出现的位置
        int cur = 0; // 以当前字符结尾的最长无重复字符的子串长度
        
        for (int i = 0; i < ch.length; i++) {
            // 计算当前字符上一次出现的位置和上一个最长无重复字符的子串开头的字符谁更靠右
            pre = Math.max(pre, map[ch[i]]);
            cur = i - pre; // 当前字符结尾的最长无重复字符的子串长度
            len = Math.max(len, cur); // 保留最大的
            map[ch[i]] = i; // 记录下当前字符的位置
        }
        return len;
    }
}