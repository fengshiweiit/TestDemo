package leetcode;

/**
 * @Description
 * @Date 2019/6/27 14:33
 * @Created by Feng Shiwei
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 */
public class Demo21 {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            //记录所有的最大值
            sum += num;
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
