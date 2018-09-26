package thread;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by fengshiwei on 2018/8/2.
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

        //new singleThreadExecutor 创建一个单线程的线程池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        ExecutorService executorService = Executors.newCachedThreadPool();

        //创建一个固定线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            final int no = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(no + "线程开始");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(no + "线程结束");
//                    try {
//                        countDownLatch.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            };
//            Worker worker = new Worker(String.valueOf(i), countDownLatch);
            executorService.execute(runnable);
        }
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(UUID.randomUUID().toString().toLowerCase().replaceAll("-", ""));
    }
}
