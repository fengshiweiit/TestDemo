package leetcode;

import java.util.StringJoiner;

/**
 * @Description
 * @Date 2019/6/26 11:46
 * @Created by Feng Shiwei
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 *
 */
public class Demo15 {

    public static void main(String[] args) {
        String word = "Let's take LeetCode contest";
        String s = reverseWords(word);
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (String word : words) {
            char[] chars = word.toCharArray();

            int begin = 0;

            int end = chars.length - 1;

            while (begin < end) {
                char temp = chars[begin];
                chars[begin] = chars[end];
                chars[end] = temp;
                begin++;
                end--;
            }
            stringBuffer.append(String.valueOf(chars) + " ");
        }
        String s1 = stringBuffer.toString();
        return s1.substring(0,s1.length()-1);
    }
}
