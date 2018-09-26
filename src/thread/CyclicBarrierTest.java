package thread;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by fengshiwei on 2018/8/2.
 */
//和CountDownLatch有点像 都是等一段线程执行完成之后才能进行下一段任务
public class CyclicBarrierTest {

    public static void main(String[] args) {
        //只有当三个线程阻塞了之后，才会执行形参中的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new BarrierTest());

        //开启多个线程去执行任务
        for (int i = 0; i < 6; i++) {
            WorkTask workTask = new WorkTask(String.valueOf(i), cyclicBarrier);
            new Thread(workTask).start();
        }

    }

    static class BarrierTest implements Runnable {
        @Override
        public void run() {
            System.out.println("线程执行结束============================");
        }
    }

    static class WorkTask implements Runnable {

        private String name;

        private CyclicBarrier cyclicBarrier;

        public WorkTask(String name, CyclicBarrier cyclicBarrier) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println(name + "线程开始阻塞执行");
//                System.out.println(name + "线程开始等待");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + "线程执行结束");
        }
    }
}
