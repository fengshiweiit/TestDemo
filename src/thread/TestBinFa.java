package thread;


import sun.net.www.http.HttpClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TestBinFa {

    // 总的请求个数
    public static final int requestTotal = 1000;

    // 同一时刻最大的并发线程的个数
    public static final int concurrentThreadNum = 20;

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(requestTotal);
        //控制并发数
        Semaphore semaphore = new Semaphore(concurrentThreadNum);
        for (int i = 0; i < requestTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(count);
        System.out.println(10 | 5);
    }

    private static void add() {
        count++;
    }
}