package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，
 * 每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
 * 如果可以变为 1，那么这个数就是快乐数。
 *
 * 例：
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class Demo7 {
    public static void main(String[] args) {
        boolean happy = isHappy(7);
        System.out.println(happy);
    }

    private static Set<Integer> set = new HashSet<>();
    public static boolean isHappy(int n) {
        Integer sum = toNumArray(n);
        if (set.contains(sum)) {
            return false;
        }
        set.add(sum);
        if (sum == 1) {
            return true;
        }else {
            if (isHappy(sum)){
                return true;
            }
        }
        return false;
    }

    public static Integer toNumArray(int target){
        Integer sum = 0;
        String s = String.valueOf(target);
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(Integer.parseInt(String.valueOf(aChar)));
        }
        for (Integer num : list) {
            sum += num * num;
        }
        return sum;
    }
}
