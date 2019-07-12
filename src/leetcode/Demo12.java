package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
 * 数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗?
 * 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 */
public class Demo12 {

    public static void main(String[] args) {
        int[] nums = {1, 1};
        findDisappearedNumbers(nums);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums1) {
//        int length = nums.length;
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        List<Integer> finalList = new ArrayList<>();
//        for (int i = 1; i <= length; i++) {
//            if (!list.contains(i)){
//                finalList.add(i);
//            }
//        }
//        return finalList;
        //思路 将数组的每一个数字作为索引把对应索引位置的数字编程负数，
        // 如果没有变的则说明是消失的
        int[] nums =  {4,3,2,7,8,2,3,1};
        int length = nums.length;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[nums[i] - 1] = nums[nums[i] - 1] > 0 ? -nums[nums[i]- 1] : nums[nums[i] - 1];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (array[i] >= 0) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
