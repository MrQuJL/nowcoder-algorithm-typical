import java.util.*;

/**
 * 题目名称：左旋字符串
 * 题目描述：对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。
 */
public class Translation {
    /**
     * 思路：
     * 将字符串复制一份拼接在原串末尾：ABCDEABCDE
     * 截取字符串[n, len + n) --> DEABC
     */
    public String stringTranslation(String A, int n, int len) {
        return (A + A).substring(len, A.length() + len);
    }
}