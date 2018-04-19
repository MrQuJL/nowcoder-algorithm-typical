import java.util.*;

/**
 * 题目名称：句子的单词间逆序
 * 题目描述：对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，
 * 字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。
 */
public class Reverse {
    public String reverseSentence(String A, int n) {
        char[] ch = A.toCharArray();
        // 1.先对字符串进行整体翻转
        reverseStr(ch, 0, A.length() - 1);
        // 2.再对每个单词间做翻转
        int last = -1;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                int next = i;
                reverseStr(ch, last + 1, next - 1);
                last = next;
            }
        }
        reverseStr(ch, last + 1, ch.length - 1);
        return new String(ch);
    }
    
    /**
     * 将字符串中指定范围内的字符翻转
     */
    public void reverseStr(char[] ch, int start, int end) {
        while (start < end) {
            swapChar(ch, start++, end--);
        }
    }
    
    public void swapChar(char[] ch, int src, int des) {
        char temp = ch[src];
        ch[src] = ch[des];
        ch[des] = temp;
    }
    
}