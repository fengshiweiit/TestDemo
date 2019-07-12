package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Description
 * @Date 2019/6/28 15:17
 * @Created by Feng Shiwei
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class Demo24 {

    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        int target = -1;
        int i = threeSumClosest(nums, target);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int returnNum = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int result = nums[i] + nums[begin] + nums[end];
                int total = result - target;
                int abs = Math.abs(total);
                if (abs == 0) {
                    return target;
                }
                if (total < 0) {
                    begin ++;
                }else {
                    end --;
                }
                if (Math.abs(total) < close) {
                    close = Math.abs(total);
                    returnNum = result;
                }
            }
        }

        return returnNum;
    }
}
