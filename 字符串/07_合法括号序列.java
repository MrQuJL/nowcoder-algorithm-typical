import java.util.*;

/**
 * 题目名称：合法括号序列
 * 题目描述：对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 扩展：
 * 卡特兰数：多对括号所组成的合法表达式所组成的序列的个数
 */
public class Parenthesis {
    /**
     * 思路：
     * 通过一个hash表存储左括号和右括号出现的次数
     * 出现的次数相同则证明是合法的
     */
    public boolean chkParenthesis(String A, int n) {
        // 合法性判断
        byte[] map = new byte[2];
        char[] ch = A.toCharArray();
        // 统计左右括号出现的次数
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                map[0]++;
            } else if (ch[i] == ')') {
                map[1]++;
            }
        }
        return map[0] == map[1] ? true : false;
    }
}