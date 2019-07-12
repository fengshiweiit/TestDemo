package leetcode;

/**
 *给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 */
public class Demo11 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,3,5,9,12};
        int target = 9;
        int search = search(nums, target);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (right >= left) {
            int mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid;
            }else if (nums[mid] > target) {
                right = mid;
            }else if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }
}
