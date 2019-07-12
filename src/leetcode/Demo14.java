package leetcode;

/**
 * @Description
 * @Date 2019/6/26 11:29
 * @Created by Feng Shiwei
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 */
public class Demo14 {

    public static void main(String[] args) {
        String target = "hello1";
        char[] chars = reverseString(target.toCharArray());
        System.out.println(chars);
    }

    public static char[] reverseString(char[] s) {
        int begin = 0;

        int end = s.length - 1;
//        for (int i = 0; i < s.length; i++) {
//
//        }
        while (begin < end) {
            char temp = s[begin];
            s[begin] = s[end];
            s[end] = temp;
            begin++;
            end--;
        }
        return s;
    }
}
