package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by fengshiwei on 2018/8/2.
 */
public class CallableTest {

    public static void main(String[] args) {

        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        MyCallable2 myCallable2 = new MyCallable2();
        FutureTask<Integer> futureTask1 = new FutureTask<Integer>(myCallable2);
        new Thread(futureTask1).start();
    }

    static class MyCallable implements Callable {
        @Override
        public Object call() throws Exception {
            Thread.sleep(1000);
            System.out.println("线程开始执行");
            return 1;
        }
    }

    static class MyCallable2 implements Callable {
        @Override
        public Object call() throws Exception {
            System.out.println("线程2开始执行");
            return 2;
        }
    }
}
