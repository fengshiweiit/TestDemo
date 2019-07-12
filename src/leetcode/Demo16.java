package leetcode;

import java.util.Stack;

/**
 * @Description
 * @Date 2019/6/26 19:00
 * @Created by Feng Shiwei
 */
public class Demo16 {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,6,6,6,6,6,6};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i:nums){
            if (stack.empty() || i == stack.peek()) {
                stack.push(i);
            } else {
                stack.pop();
            }
        }
        return stack.peek();
    }
}
