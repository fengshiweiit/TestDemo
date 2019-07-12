package testdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description
 * @Date 2019/6/18 18:51
 * @Created by Feng Shiwei
 */
public class MainTest {

    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            list.add(123);
        });

        CompletableFuture completableFuture1 = CompletableFuture.runAsync(() -> {
            list.add(456);
        });

        CompletableFuture completableFuture2 = CompletableFuture.runAsync(() -> {
            list.add(789);
        });

        completableFuture.join();
        completableFuture1.join();
        completableFuture2.join();

        System.out.println(list);

    }
}
