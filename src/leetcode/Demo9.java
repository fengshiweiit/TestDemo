package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class Demo9 {

    public static void main(String[] args) {
        getRow(8);
    }

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> list = new ArrayList<>();

        //偶数
        if (rowIndex%2 == 0) {
            int next = 1;
            for (int i = 0; i < rowIndex/2; i++) {
                list.add(next);
                next += rowIndex - 2;
            }
        }
        return list;
    }
}
