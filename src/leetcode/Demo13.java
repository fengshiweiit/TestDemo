package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，
 * 其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *示例 ：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */
public class Demo13 {

    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        String s1 = reverseOnlyLetters(s);
        System.out.println(s1);
    }

    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int length = chars.length;
        StringBuffer buffer = new StringBuffer();
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char aChar = chars[i];
            boolean flag = ('a' < aChar && aChar < 'z') || ('A' < aChar && aChar < 'Z');
            if (!flag) {
                indexList.add(i);
            }else {
                buffer.append(aChar);
            }
        }
        return null;
    }
}
