package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by fengshiwei on 2018/8/3.
 */
public class ForkJoinTest {

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ComputeDemo computeDemo = new ComputeDemo(1, 100000000);
//        forkJoinPool.execute(computeDemo); 无返回值
//        Integer invoke = forkJoinPool.invoke(computeDemo); 执行某一个返回结果
        long l = System.currentTimeMillis();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(computeDemo);
        try {
            Integer result = submit.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long l1 = System.currentTimeMillis();
        int r = Integer.MAX_VALUE;
        System.out.println(r);
        System.out.println(l1 - l + "========================="); //这里不知道为什么不是fork的越多用时越少
    }

    static class ComputeDemo extends RecursiveTask<Integer> {

        private Integer begin;

        private Integer end;

        private static final int spilt = 10;

        public ComputeDemo(Integer begin, Integer end) {
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            Boolean flag = end - begin <= spilt;
            if (flag) {
                for (int i = begin; i <= end; i++) {
                    sum += i;
                }
            } else {
                //拆分成两个子任务去执行
                int middle = (end + begin) / 2;
                ComputeDemo computeDemo = new ComputeDemo(begin, middle);
                ComputeDemo computeDemo1 = new ComputeDemo(middle + 1, end);

//                System.out.println(middle + "========================");

                //调用fork方法的时候会重新去调用compute方法计算！！！ 巨重要
                computeDemo.fork();
                computeDemo1.fork();

                Integer first = computeDemo.join();
                Integer last = computeDemo1.join();
                sum = first + last;
//                System.out.println(first + "================" + last);
//                System.out.println(1);
            }

            return sum;
        }
    }
}
