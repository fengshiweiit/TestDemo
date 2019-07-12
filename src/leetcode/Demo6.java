package leetcode;

/**
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和
 * ，包含 i,  j 两点。
 * 例子：
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 */
public class Demo6 {

    private int[] array;

    public Demo6(int[] nums) {
        this.array = nums;
    }

    public int sumRange(int i, int j) {
        if (i == j){
            return array[i];
        }
        int sum = 0;
        while (i <= j){
            sum += array[i];
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Demo6 demo6 = new Demo6(new int[]{1,2,3,4});
        int i = demo6.sumRange(1, 3);
        System.out.println(i);
    }
}
