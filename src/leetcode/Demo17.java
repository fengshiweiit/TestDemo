package leetcode;

/**
 * @Description
 * @Date 2019/6/26 19:52
 * @Created by Feng Shiwei
 */
public class Demo17 {

    public static void main(String[] args) {
        isPalindrome(10);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            begin ++ ;
            end -- ;
        }
        return true;
    }
}
