package leetcode;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class Demo4 {

    public static void main(String[] args) {
        int[] arr1 = {2,3,4};
        int[] arr2 = {26,3,4};
        int[] objects = testDemo(arr1, arr2);
        System.out.println(objects);
    }

    public static int[] testDemo(int[] arr1, int[] arr2) {
        Set<Integer> finalList = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        for (int i : arr2) {
            if (list.contains(i)){
                finalList.add(i);
            }
        }
        List<Integer> list1 = new ArrayList<>(finalList);

        int[] a = new int[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            a[i] = list1.get(i);
        }
        return a;
    }
}
