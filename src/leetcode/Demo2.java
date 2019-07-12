package leetcode;

/**
* 实现函数 ToLowerCase()，
 * 该函数接收一个字符串参数 str
 * ，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
*
*
* */
public class Demo2 {
    public static void main(String[] args) {
        String hello = testDemo("PiTAs");
        System.out.println(hello);
    }

    public static String testDemo(String origin){
        char[] chars = origin.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int aChar1 = chars[i];
            if (aChar1 >= 65 && aChar1 <= 90){
                aChar1 += 32;
                chars[i] = (char) aChar1;
            }
        }

        String s = String.valueOf(chars);
        return s;
    }
}
