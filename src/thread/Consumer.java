package thread;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by fengshiwei on 2018/9/26.
 */
public class Consumer implements Runnable {

    private List<Object> list;

    private Exchanger exchanger;

    public Consumer(List<Object> list, Exchanger exchanger) {
        this.list = list;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Object exchange = exchanger.exchange(list);
                System.out.println("Consumer===========" + exchange);
                list.remove(exchange);
            }
            System.out.println("Consumer: " + list.size());
            for (int j = 0; j < 10; j++) {
                Object message = list.get(0);
                System.out.println("Consumer: " + message);
                list.remove(0);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
