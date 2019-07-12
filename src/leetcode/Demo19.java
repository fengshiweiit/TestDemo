package leetcode;

import java.util.*;

/**
 * @Description
 * @Date 2019/6/27 11:08
 * @Created by Feng Shiwei
 */
public class Demo19 {

    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            list.add(num);
            set.add(num);
        }
        if (list.size() == set.size()) {
            return true;
        }else {
            return false;
        }


    }
}
