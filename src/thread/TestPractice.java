package thread;

import org.junit.Test;

import java.util.*;

/**
 * Created by fengshiwei on 2018/9/25.
 */
public class TestPractice {

    //找出数组中出现次数大于一半的数 int[] num = {1,2,2,2,2,2,2,4,2,4,6,4,2,6,8,2,7,7};
    @Test
    public void test1() {
        int[] num = {1,2,2,2,2,2,2,4,2,4,6,4,2,6,8,2,7,7};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : num) {
            if (map.containsKey(i)){
                Integer integer = map.get(i);
                map.put(i, integer + 1);
                if (integer + 1 > num.length/2) {
                    System.out.println(i);
                    break;
                }
            }else {
                map.put(i, i);
            }
        }
        Collection<Integer> values = map.values();
    }

    /*
    * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
    * 例如6、8都是丑数，但14不是，因为它包含因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * 从小到大输出1500以内的丑数
    * */
    @Test
    public void test2() {
        for (int i = 1; i < 1501; i++) {
            int second = i/2;
        }
    }
}
