package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by fengshiwei on 2018/7/27.
 */
public class Worker implements Runnable{

    private String name;

    private CountDownLatch countDownLatch;

    public Worker(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(name + "--------------->> is begin : " + countDownLatch.getCount());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "--------------->> is end : " + countDownLatch.getCount());
        //次数减少一
        countDownLatch.countDown();
    }
}
