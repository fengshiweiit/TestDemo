package leetcode;

import java.util.*;

/**
 * @Description
 * @Date 2019/6/27 17:44
 * @Created by Feng Shiwei
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案
 */
public class Demo23 {

    public static void main(String[] args) {
        String s = "cbafdsfbbbfdaabbccddccbbaasfbbbbbbd";

        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1){
            return s;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            buffer.append("#");
            buffer.append(s.charAt(i));
        }
        buffer.append('#');
        s = buffer.toString();
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        char[] chars = s.toCharArray();

        //中心扩散
        for (int i = 1; i < chars.length; i++) {
            int n = 1;
            while (true) {
                if (i - n >= 0 && i + n < chars.length) {
                    if (chars[i - n] == chars[i + n]) {
                        if (n > maxLength) {
                            maxLength = n;
                            map.put(maxLength, i);
                        }
                        n++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Integer max = list.get(list.size() - 1);
        Integer index = map.get(max);
        return s.substring(index-max, max+index+1).replace("#" , "");
    }
}