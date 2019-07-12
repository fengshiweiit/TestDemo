package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 给定一个按非递减顺序排序的整数数组 A，
 * 返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        int[] ints = testDemo(arr);
        System.out.println();
    }

    public static int[] testDemo(int[] origin) {
        int[] ints = new int[origin.length];
        for (int i = 0; i < origin.length; i++) {
            int a = origin[i] * origin[i];
            ints[i] = a;
        }

        Arrays.sort(ints);
        return ints;
    }
}
