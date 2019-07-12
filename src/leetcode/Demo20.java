package leetcode;

/**
 * @Description
 * @Date 2019/6/27 14:17
 * @Created by Feng Shiwei
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Demo20 {

    public static void main(String[] args) {
        /**
         * 如果我们现在在n阶，那么我们可以迈一步或者迈两步，结果就是
         * f(n) = f(n-1) + f(n-2)。。。即n的台阶的种数应该是，
         * n－1阶的种数与n－2阶种数之和（由于第一步就不一样，所有，后面的二者互相独立）。
         */
        int i = climbStairs(10);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        return climbStair(n);
    }

    private static int climbStair(int i) {
        if (i == 1){
            return 1;
        }
        if (i == 2) {
            return 2;
        }
        return climbStair(i - 1) + climbStair(i - 2);
    }
}
