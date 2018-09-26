package thread;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by fengshiwei on 2018/9/26.
 */
public class Producer implements Runnable {

    private String name;

    private Exchanger<String> exchanger;

    public Producer(String name, Exchanger<String> exchanger) {
        this.name = name;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "原数据为"+ name);
        try {
            Thread.sleep(100);
            name = exchanger.exchange(name);
            System.out.println(Thread.currentThread().getName() + "交换后的数据为"+ name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
