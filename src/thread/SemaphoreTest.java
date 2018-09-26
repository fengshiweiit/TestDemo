package thread;

import java.util.concurrent.Semaphore;

/**
 * Created by fengshiwei on 2018/8/1.
 */
public class SemaphoreTest {

    public static void main(String[] args) {

        //一次性只允许三个线程能访问,只有当前面的线程释放了之后 后面的线程才可以继续执行
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                        System.out.println(no + "线程进来了");
                        semaphore.acquire();
                        Thread.sleep(1);
                        System.out.println(no + "线程获取了执行权");
                        semaphore.release();
                        System.out.println(no + "线程释放了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(runnable).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程结束=====================");
    }
}
