package thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by fengshiwei on 2018/7/27.
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        //初始化一个计数器
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            Worker worker1 = new Worker("天才" + i, countDownLatch);
            new Thread(worker1).start();
        }
        try {
            long count = countDownLatch.getCount();
            System.out.println(count + "================");
            //帕努单当countDown减少到0的时候才可以运行下面的代码
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("我是神啊！！！！！");
    }
}
