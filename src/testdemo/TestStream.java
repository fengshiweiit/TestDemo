package testdemo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Description
 * @Date 2019/7/5 11:01
 * @Created by Feng Shiwei
 */
public class TestStream {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, 3, 3, 2);
        Map<Integer, Long> collect = list.stream().collect(groupingBy(Integer::intValue, Collectors.counting()));
        System.out.println(collect);
    }
}
