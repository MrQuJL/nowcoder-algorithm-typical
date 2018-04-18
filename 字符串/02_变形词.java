import java.util.*;

/**
 * 题目名称：词语变形
 * 题目描述：对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，
 * 则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * 测试样例：
 * "abc",3,"bca",3
 * 返回：true
 */
public class Transform {
    /**
     * 思路：
     * 1.建立两个哈希表分别统计每个字符串中字符出现的次数
     * 2.比对两个哈希表中每个字符出现的次数是否相同
     */
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // 1.建立两个哈希表
        int[] mapA = new int[65536];
        int[] mapB = new int[65536];
        // 2.分别统计每个字符串中字符出现的次数
        char[] chA = A.toCharArray();
        char[] chB = B.toCharArray();
        for (int i = 0; i < lena; i++) {
            mapA[chA[i]]++;
        }
        for (int i = 0; i < lenb; i++) {
            mapB[chB[i]]++;
        }
        // 3.比对两个哈希表中每个字符出现的次数是否相同
        for (int i = 0; i < mapA.length; i++) {
            if (mapA[i] != mapB[i]) {
                return false;
            }
        }
        return true;
    }
}