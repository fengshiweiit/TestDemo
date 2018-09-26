package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by fengshiwei on 2018/7/27.
 */
public class BlockingQueueTest implements Delayed{

    public static void main(String[] args) throws Exception {
        final BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(16);
        for (int i = 0; i < 16; i++) {
            arrayBlockingQueue.put(i+1 + "---------->>");
        }

        //开启4个线程去输出这个队列里的东西
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            String take = arrayBlockingQueue.take();
                            parse(take);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    public static void parse(String s){
        System.out.println(s + System.currentTimeMillis() + "--------------->>" + Thread.currentThread().getName());
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return 0;
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}
