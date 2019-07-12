package leetcode;

import java.util.*;

/**
 * @Description
 * @Date 2019/6/27 16:07
 * @Created by Feng Shiwei
 *
 *给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Demo22 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);
        //先排序 然后双指针
        for (int i = 0; i < nums.length-2; i++) {
            int target = nums[i];
            if (target > 0) {
                break;
            }
            if (i-1 >= 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int result = nums[left] + nums[right] + target;
                if (result > 0 || (right<nums.length - 1 && nums[right] == nums[right + 1])) {
                    right --;
                }else if (result < 0 || (left > i + 1 && nums[left] == nums[left - 1])) {
                    left ++;
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    right --;
                    left ++;
                }
            }
        }
        return lists;
    }
}
